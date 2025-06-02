namespace Common.MessageModels;


public class OrderMessage
{
    public required string Equipment { get; set; }
    public required string TeamName { get; set; }
    
    public required string OrderId { get; set; }
}