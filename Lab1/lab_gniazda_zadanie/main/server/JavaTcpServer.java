package server;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class JavaTcpServer {

    public static void main(String[] args) throws IOException {
        System.out.println("JAVA TCP SERVER");
        int portNumber = 12345;
        ServerSocket serverSocket = null;
        DatagramSocket udpSocket = null;
        ConcurrentHashMap<String, Socket> clients = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, InetSocketAddress> udpClients = new ConcurrentHashMap<>();

        try {

            serverSocket = new ServerSocket(portNumber);
            udpSocket = new DatagramSocket(portNumber);
            new Thread(new UdpChannel(udpSocket,udpClients)).start();
            while (true) {

                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());
                new Thread(new TcpServerClient(clientSocket, clients )).start();


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
            if (udpSocket != null) {
                udpSocket.close();
            }
        }

    }

}
