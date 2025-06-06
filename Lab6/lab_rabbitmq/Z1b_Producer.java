// Z1b_Producer.java
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Z1b_Producer {
    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        String QUEUE_NAME = "queue1";
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        int[] tasks = {1,5,1,5,1,5,1,5,1,5};
        for (int t : tasks) {
            String msg = Integer.toString(t);
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes("UTF-8"));
            System.out.println("Sent: " + msg);
        }
        channel.close();
        connection.close();
    }
}
