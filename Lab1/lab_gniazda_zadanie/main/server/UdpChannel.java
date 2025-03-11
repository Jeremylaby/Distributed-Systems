package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentHashMap;

public class UdpChannel implements Runnable {
    private final DatagramSocket udpSocket;
    private final ConcurrentHashMap<String, InetSocketAddress> udpClients;

    public UdpChannel(DatagramSocket udpSocket, ConcurrentHashMap<String, InetSocketAddress> udpClients) {
        this.udpSocket = udpSocket;
        this.udpClients = udpClients;
    }

    private void sendToAll(InetSocketAddress senderAddress, byte[] msg) {
        for (InetSocketAddress clientAddress : udpClients.values()) {
            if (!clientAddress.equals(senderAddress)) {
                System.out.println("Sending message to " + clientAddress);
                DatagramPacket packet = new DatagramPacket(msg, msg.length, clientAddress);
                try {
                    udpSocket.send(packet);
                } catch (IOException e) {
                    throw new RuntimeException("Error sending UDP message", e);
                }
            }
        }
    }

    @Override
    public void run() {
        try {

            while (true) {
                byte[] buffer = new byte[4096];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                udpSocket.receive(packet);
                String msg = new String(packet.getData(), 0, packet.getLength(), StandardCharsets.UTF_8);
                InetSocketAddress clientAddress = new InetSocketAddress(packet.getAddress(), packet.getPort());
                udpClients.putIfAbsent(clientAddress.toString(), clientAddress);
                if (msg.equals("/q")) {
                    udpClients.remove(clientAddress.toString());
                    System.out.println("Client " + clientAddress + " removed.");
                } else if (msg.equals("/new")) {
                    System.out.println("UDP Clients: " + udpClients.size());
                } else {
                    sendToAll(clientAddress, packet.getData());
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
