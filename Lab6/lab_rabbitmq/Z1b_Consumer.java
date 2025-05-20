// Z1b_Consumer_QoS.java
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Z1b_Consumer {
    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.basicQos(1);
        String QUEUE_NAME = "queue1";
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws java.io.IOException {
                String message = new String(body, "UTF-8");
                int timeToSleep = Integer.parseInt(message);
                try { Thread.sleep(timeToSleep * 1000); } catch (InterruptedException e) {}
                channel.basicAck(envelope.getDeliveryTag(), false);
                System.out.println("QoS processed: " + message + "s");
            }
        };
        channel.basicConsume(QUEUE_NAME, false, consumer);
    }
}
