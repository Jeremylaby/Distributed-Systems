using RabbitMQ.Client;
using RabbitMQ.Client.Events;
using Common;
using Common.MessageModels; 
using System.Text;

Console.WriteLine("[ADMIN] Uruchomiono admina.");

ConnectionFactory factory = new ConnectionFactory();
factory.UserName = "guest";
factory.Password = "guest";
factory.VirtualHost = "/";
factory.HostName = "localhost";

IConnection conn = await factory.CreateConnectionAsync();
IChannel channel = await conn.CreateChannelAsync();
await channel.ExchangeDeclareAsync("admin_log", ExchangeType.Fanout);

await channel.ExchangeDeclareAsync("admin_exchange", ExchangeType.Direct);


string adminQueue = "admin_log_queue";
await channel.QueueDeclareAsync(adminQueue, durable: false, exclusive: false, autoDelete: false);
await channel.QueueBindAsync(adminQueue, "admin_log", routingKey: "");


var consumer = new AsyncEventingBasicConsumer(channel);
consumer.ReceivedAsync += async (model, ea) =>
{
    var body = ea.Body.ToArray();
    var adminMsg = SerializationHelper.Deserialize<AdminMessage>(body);
    if (adminMsg != null)
        Console.WriteLine($"[ADMIN] LOG: {adminMsg.Content} (do: {adminMsg.Target})");
    else
        Console.WriteLine("[ADMIN] Otrzymano nieprawidłową wiadomość.");
    await channel.BasicAckAsync(ea.DeliveryTag, false);
};

await channel.BasicConsumeAsync(queue: adminQueue, autoAck: false, consumer: consumer);



while (true)
{
    Console.WriteLine("\n[ADMIN] Wpisz wiadomość (albo ENTER aby zakończyć):");
    string? content = Console.ReadLine();
    if (string.IsNullOrWhiteSpace(content)) break;

    Console.WriteLine("Do kogo? (teams / suppliers / all):");
    string target = Console.ReadLine()?.ToLower() ?? "all";
    if (target != "teams" && target != "suppliers" && target != "all")
    {
        Console.WriteLine("[ADMIN] Nieprawidłowy cel wiadomości.");
        continue;
    }

    var adminMsg = new AdminMessage
    {
        Content = content,
        Target = target
    };

    var body = SerializationHelper.Serialize(adminMsg);

    string routingKey = target switch
    {
        "teams" => "teams",
        "suppliers" => "suppliers",
        _ => "all"
    };

    await channel.BasicPublishAsync("admin_exchange", routingKey, body: body);
    Console.WriteLine($"[ADMIN] Wysłano do: {routingKey}");
}

Console.WriteLine("[ADMIN] Zakończono.");
