package client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class UdpReceiveMsg implements Runnable {
    private final DatagramSocket udpSocket;

    public UdpReceiveMsg(DatagramSocket udpSocket) {
        this.udpSocket = udpSocket;
    }

    @Override
    public void run() {
        try {
            while (true) {
                byte[] buffer = new byte[4096];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                udpSocket.receive(packet);
                String receivedMsg = new String(packet.getData(), 0, packet.getLength(), StandardCharsets.UTF_8);
                System.out.println("UDP Channel: ");
                System.out.println(receivedMsg.trim());
            }
        } catch (IOException e) {
        }
    }
}
