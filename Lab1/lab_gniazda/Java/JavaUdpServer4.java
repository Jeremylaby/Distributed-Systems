import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class JavaUdpServer4 {
    public static void main(String args[]) {
        System.out.println("JAVA UDP SERVER");
        DatagramSocket socket = null;
        int portNumber = 9008;

        try {
                socket = new DatagramSocket(portNumber);
            byte[] receiveBuffer = new byte[4]; // Odbieramy 4 bajty (int)

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);

                ByteBuffer buffer = ByteBuffer.wrap(receivePacket.getData());
                buffer.order(ByteOrder.LITTLE_ENDIAN);
                int receivedNumber = buffer.getInt();

                System.out.println("Received number: " + receivedNumber);


                int responseNumber = receivedNumber + 1;
                ByteBuffer responseBuffer = ByteBuffer.allocate(4);
                responseBuffer.order(ByteOrder.LITTLE_ENDIAN);
                responseBuffer.putInt(responseNumber);

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                DatagramPacket responsePacket = new DatagramPacket(responseBuffer.array(), responseBuffer.array().length, clientAddress, clientPort);
                socket.send(responsePacket);

                System.out.println("Sent back number: " + responseNumber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
