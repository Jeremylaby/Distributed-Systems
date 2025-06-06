namespace Common.MessageModels;

public class AdminLogMessage
{
    public required string Reason { get; set; }
    
    public required string Target { get; set; }
    
    public required string Sender { get; set; }
    
    public required string Equipment { get; set; }
    public required string OrderId { get; set; }
    
}