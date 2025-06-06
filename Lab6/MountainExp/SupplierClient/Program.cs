using RabbitMQ.Client;
using RabbitMQ.Client.Events;
using Common;
using Common.MessageModels;

if (args.Length < 2)
{
    Console.WriteLine("Użycie: dotnet run -- D1 tlen buty");
    return;
}

//wczytanie argsów
var supplierName = args[0];
var supportedEquipment = args.Skip(1).ToList();

//Inicializajca połączenia
Console.WriteLine($"[SUPPLIER {supplierName}] Obsługiwane sprzęty: {string.Join(", ", supportedEquipment)}");
ConnectionFactory factory = new ConnectionFactory();
factory.UserName = "guest";
factory.Password = "guest";
factory.VirtualHost = "/";
factory.HostName = "localhost";

IConnection conn = await factory.CreateConnectionAsync();
IChannel channel = await conn.CreateChannelAsync();

//kanał z klientem
await channel.ExchangeDeclareAsync("orders_exchange", ExchangeType.Direct);

//kanałna admin log
await channel.ExchangeDeclareAsync("admin_log", ExchangeType.Fanout);

await channel.BasicQosAsync(0, 1, false);
string adminQueue = $"admin_suppliers_{supplierName}";
await channel.QueueDeclareAsync(adminQueue, false, false, false);
await channel.QueueBindAsync(adminQueue, exchange: "admin_exchange", "suppliers");
await channel.QueueBindAsync(adminQueue, exchange: "admin_exchange", "all");
var adminConsumer = new AsyncEventingBasicConsumer(channel);
adminConsumer.ReceivedAsync += async (model, ea) =>
{
    var adminMsg = SerializationHelper.Deserialize<AdminMessage>(ea.Body.ToArray());
    if (adminMsg != null)
    {
        Console.WriteLine($"[SUPPLIER {supplierName}] WIADOMOŚĆ OD ADMINA: {adminMsg.Content}");
    }

    await channel.BasicAckAsync(ea.DeliveryTag, false);
};

await channel.BasicConsumeAsync(queue: adminQueue, autoAck: false, consumer: adminConsumer);
foreach (var eq in supportedEquipment)
{
    string queueName = $"equipment.{eq}";

    await channel.QueueDeclareAsync(queueName, durable: false, exclusive: false, autoDelete: false);
    await channel.QueueBindAsync(queue: queueName, exchange: "orders_exchange", routingKey: eq);
    
    var consumer = new AsyncEventingBasicConsumer(channel);
    consumer.ReceivedAsync += async (model, ea) =>
    {
        var order = SerializationHelper.Deserialize<OrderMessage>(ea.Body.ToArray());
        if (order == null)
        {
            Console.WriteLine($"[SUPPLIER {supplierName}] Błąd deserializacji.");
            await channel.BasicAckAsync(ea.DeliveryTag, false);
            return;
        }

        Console.WriteLine($"[SUPPLIER {supplierName}] Zlecenie na {order.Equipment} od {order.TeamName}");

        var confirmation = new ConfirmationMessage
        {
            OrderId = order.OrderId,
            Equipment = order.Equipment,
            SupplierName = supplierName,
            TeamName = order.TeamName
        };
        var adminLog = new AdminLogMessage
        {
            Equipment = order.Equipment,
            Reason = "Confirmation",
            Sender = supplierName,
            Target = order.TeamName,
            OrderId = order.OrderId
        };

        var confirmBody = SerializationHelper.Serialize(confirmation);
        var adminLogBody = SerializationHelper.Serialize(adminLog);

        await channel.BasicPublishAsync(exchange: "", routingKey: $"team.{order.TeamName}", body: confirmBody);
        await channel.BasicPublishAsync(exchange: "admin_log", routingKey: "", body: adminLogBody);
        await channel.BasicAckAsync(ea.DeliveryTag, false);
    };

    await channel.BasicConsumeAsync(queue: queueName, autoAck: false, consumer: consumer);
    
}

Console.WriteLine($"[SUPPLIER {supplierName}] Oczekiwanie na zlecenia...");
Console.ReadLine();