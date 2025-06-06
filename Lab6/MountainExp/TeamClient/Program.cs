using RabbitMQ.Client;
using RabbitMQ.Client.Events;
using Common;
using Common.MessageModels;


var teamName = args.Length > 0 ? args[0] : "TeamX";

Console.WriteLine($"[TEAM {teamName}] Uruchomiony");

ConnectionFactory factory = new ConnectionFactory();
factory.UserName = "guest";
factory.Password = "guest";
factory.VirtualHost = "/";
factory.HostName = "localhost";

IConnection conn = await factory.CreateConnectionAsync();
IChannel channel = await conn.CreateChannelAsync();

string teamQueue = $"team.{teamName}";

await channel.QueueDeclareAsync(teamQueue, durable: false, exclusive: false, autoDelete: false);

await channel.ExchangeDeclareAsync("admin_log", ExchangeType.Fanout);

// Exchange dla zamówień (routingKey = nazwa sprzętu)
await channel.ExchangeDeclareAsync("orders_exchange", ExchangeType.Direct);

await channel.BasicQosAsync(0, 1, false);

string adminQueue = $"admin_teams_{teamName}";
await channel.QueueDeclareAsync(adminQueue, false, false, false);
await channel.QueueBindAsync(adminQueue, exchange: "admin_exchange", "teams");
await channel.QueueBindAsync(adminQueue, exchange: "admin_exchange", "all");

var confirmConsumer = new AsyncEventingBasicConsumer(channel);
confirmConsumer.ReceivedAsync += async (model, ea) =>
{
    var msg = SerializationHelper.Deserialize<ConfirmationMessage>(ea.Body.ToArray());
    if (msg != null)
    {
        Console.WriteLine($"[TEAM {teamName}] ODEBRANO POTWIERDZENIE: {msg.Equipment} od {msg.SupplierName}, ID: {msg.OrderId}");
    }
    else
    {
        Console.WriteLine($"[TEAM {teamName}] Otrzymano nieczytelną wiadomość z potwierdzeniem.");
    }

    await channel.BasicAckAsync(ea.DeliveryTag, false);
};

await channel.BasicConsumeAsync(queue: teamQueue, autoAck: false, consumer: confirmConsumer);


var adminConsumer = new AsyncEventingBasicConsumer(channel);
adminConsumer.ReceivedAsync += async (model, ea) =>
{
    var adminMsg = SerializationHelper.Deserialize<AdminMessage>(ea.Body.ToArray());
    if (adminMsg != null)
    {
        Console.WriteLine($"[TEAM {teamName}] WIADOMOŚĆ OD ADMINA: {adminMsg.Content}");
    }

    await channel.BasicAckAsync(ea.DeliveryTag, false);
};

await channel.BasicConsumeAsync(queue: adminQueue, autoAck: false, consumer: adminConsumer);

var orders = new[] { "tlen", "tlen", "buty", "buty", "plecak", "plecak" };

foreach (var eq in orders)
{
    var order = new OrderMessage
    {
        Equipment = eq,
        TeamName = teamName,
        OrderId = Guid.NewGuid().ToString().Substring(0, 6)
    };
    var adminLog = new AdminLogMessage
    {
        Equipment = eq,
        Reason = "Order",
        Sender = teamName,
        Target = "UNKNOWN",
        OrderId = order.OrderId,
    };
    
    var adminLogBody = SerializationHelper.Serialize(adminLog);

    var body = SerializationHelper.Serialize(order);
    await channel.BasicPublishAsync("orders_exchange", routingKey: eq, body: body);
    Console.WriteLine($"[TEAM {teamName}] WYSŁANO ZAMÓWIENIE: {eq}");
    await channel.BasicPublishAsync(exchange: "admin_log", routingKey: "", body: adminLogBody);
    Thread.Sleep(500);
}

Console.WriteLine($"[TEAM {teamName}] Oczekiwanie na potwierdzenia...");
Console.ReadLine();
