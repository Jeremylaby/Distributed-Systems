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

await channel.QueueDeclareAsync("coordinator_queue", false, false, false);

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

var zamowienia = new[] { "tlen", "tlen", "buty", "buty", "plecak", "plecak" };

int id = 1;
foreach (var sprzet in zamowienia)
{
    var order = new OrderMessage
    {
        Equipment = sprzet,
        TeamName = teamName
    };

    var body = SerializationHelper.Serialize(order);
    await channel.BasicPublishAsync(exchange: "", routingKey: "coordinator_queue", body: body);
    Console.WriteLine($"[TEAM {teamName}] WYSŁANO ZAMÓWIENIE: {sprzet}");
    Thread.Sleep(500);
}

Console.WriteLine($"[TEAM {teamName}] Oczekiwanie na potwierdzenia...");
Console.ReadLine();
