namespace Common;
using System.Text;
using System.Text.Json;
    

public static class SerializationHelper
{
    public static byte[] Serialize<T>(T obj)
    {
        return Encoding.UTF8.GetBytes(JsonSerializer.Serialize(obj));
    }

    public static T? Deserialize<T>(byte[] body)
    {
        var json = Encoding.UTF8.GetString(body);
        return JsonSerializer.Deserialize<T>(json);
    }
}