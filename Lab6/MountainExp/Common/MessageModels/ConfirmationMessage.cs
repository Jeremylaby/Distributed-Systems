namespace Common.MessageModels;

public class ConfirmationMessage
{
    public required string OrderId { get; set; }           
    public required string Equipment { get; set; }         
    public required string SupplierName { get; set; }
    public required string TeamName { get; set; }
}