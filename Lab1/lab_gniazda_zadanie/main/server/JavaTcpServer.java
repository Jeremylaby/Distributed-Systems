package server;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class JavaTcpServer {
    private static final int PORT_NUMBER = 12345;
    private static final int MAX_CLIENTS = 5;
    public static void main(String[] args) throws IOException {
        System.out.println("JAVA TCP SERVER");
        //W kodzie jest parę dziur które można by poprawić
        // ale dla takiego prostego zastosowania myślę żę nie ma to sensu
        ServerSocket serverSocket = null;
        DatagramSocket udpSocket = null;
        ConcurrentHashMap<String, Socket> clients = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, InetSocketAddress> udpClients = new ConcurrentHashMap<>();

        ExecutorService threadPool = Executors.newFixedThreadPool(MAX_CLIENTS);

        try {

            serverSocket = new ServerSocket(PORT_NUMBER);
            udpSocket = new DatagramSocket(PORT_NUMBER);
            new Thread(new UdpChannel(udpSocket,udpClients)).start();
            while (true) {

                Socket clientSocket = serverSocket.accept();
                if(((ThreadPoolExecutor) threadPool).getActiveCount() < MAX_CLIENTS) {
                    System.out.println("Client connected: " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());
                    threadPool.execute(new TcpServerClient(clientSocket, clients));
                }else{
                    clientSocket.close();
                    System.out.println("Maximum client count reached");
                    System.out.println("Client disconnected: " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());
                }


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
            threadPool.shutdown();
        }

    }

}
