// Z2_Topic_Consumer.java
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Z2_Topic_Consumer {
    public static void main(String[] argv) throws Exception {
        String EXCHANGE_NAME = "topic_exchange";
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel();
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
            String queueName = channel.queueDeclare().getQueue();
            System.out.print("Enter binding pattern: ");
            String pattern = br.readLine();
            channel.queueBind(queueName, EXCHANGE_NAME, pattern);
            System.out.println("Waiting for messages matching '" + pattern + "'");
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag,
                                           Envelope envelope,
                                           AMQP.BasicProperties properties,
                                           byte[] body) {
                    String msg = new String(body);
                    System.out.println("Received: '" + msg + "' with key '" + envelope.getRoutingKey() + "'");
                }
            };
            channel.basicConsume(queueName, true, consumer);
            Thread.currentThread().join();
        }
    }
}
