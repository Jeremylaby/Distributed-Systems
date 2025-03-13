package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.nio.charset.StandardCharsets;

public class MulticastReceiveMsg implements Runnable {
    private final  MulticastSocket multicastSocket;

    public MulticastReceiveMsg(MulticastSocket multicastSocket) {
        this.multicastSocket = multicastSocket;
    }

    @Override
    public void run() {
        try{
         while(true){
             byte[] buffer = new byte[4096];
             DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
             multicastSocket.receive(packet);
             String receivedMsg = new String(packet.getData(), 0, packet.getLength(), StandardCharsets.UTF_8);
             System.out.println("Multicast Channel:");
             System.out.println(receivedMsg.trim());
         }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
