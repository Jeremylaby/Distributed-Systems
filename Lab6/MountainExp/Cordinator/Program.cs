using RabbitMQ.Client;
using RabbitMQ.Client.Events;
using Common;
using Common.MessageModels;

ConnectionFactory factory = new ConnectionFactory();
factory.UserName = "guest";
factory.Password = "guest";
factory.VirtualHost = "/";
factory.HostName = "localhost";

IConnection conn = await factory.CreateConnectionAsync();
IChannel channel = await conn.CreateChannelAsync();


await channel.QueueDeclareAsync("coordinator_queue", durable: false, exclusive: false, autoDelete: false);

// Exchange dla zamówień (routingKey = nazwa sprzętu)
await channel.ExchangeDeclareAsync("orders_exchange", type: "direct");

// Exchange dla administratora
await channel.ExchangeDeclareAsync("admin_log", type: "fanout");

// Ogranicz: 1 wiadomość naraz do konsumenta
await channel.BasicQosAsync(0, 1, false);

Console.WriteLine("[COORDINATOR] Uruchomiony, czeka na zlecenia...");

var consumer = new AsyncEventingBasicConsumer(channel);
consumer.ReceivedAsync += async (model, ea) =>
{
    var order = SerializationHelper.Deserialize<OrderMessage>(ea.Body.ToArray());
    if (order == null)
    {
        Console.WriteLine("[COORDINATOR] Błąd deserializacji wiadomości.");
        await channel.BasicAckAsync(ea.DeliveryTag, false);
        return;
    }
    var eq = order.Equipment;
    
    var body = SerializationHelper.Serialize(order);
    await channel.BasicPublishAsync("orders_exchange", routingKey: eq, body: body);

    Console.WriteLine($"[COORDINATOR] Zlecenie na {eq} wysłane do exchange 'orders_exchange'");

    await channel.BasicPublishAsync("admin_log", routingKey: "", body: body);
    await channel.BasicAckAsync(ea.DeliveryTag, false);
};

await channel.BasicConsumeAsync("coordinator_queue", autoAck: false, consumer: consumer);

Console.ReadLine();
