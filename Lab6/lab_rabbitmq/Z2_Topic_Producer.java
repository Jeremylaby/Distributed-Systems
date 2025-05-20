// Z2_Topic_Producer.java
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Z2_Topic_Producer {
    public static void main(String[] argv) throws Exception {
        String EXCHANGE_NAME = "topic_exchange";
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel();
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
            while (true) {
                System.out.print("Enter routing key  or 'exit': ");
                String key = br.readLine();
                if (key == null || "exit".equals(key)) break;
                System.out.print("Enter message: ");
                String message = br.readLine();
                channel.basicPublish(EXCHANGE_NAME, key, null, message.getBytes("UTF-8"));
                System.out.println("Sent '" + message + "' with key '" + key + "'");
            }
        }
    }
}
