package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class TcpServerClient implements Runnable {
    private final Socket clientSocket;
    private final ConcurrentHashMap<String, Socket> clients;
    private String clientNick;

    public TcpServerClient(Socket clientSocket, ConcurrentHashMap<String, Socket> clients) {
        this.clientSocket = clientSocket;
        this.clients = clients;
    }

    private void chooseNick(PrintWriter out, BufferedReader in) throws IOException {
        String nickName;
        while (true) {
            out.println("Enter your nickname: ");
            nickName = in.readLine();
            if (nickName == null || nickName.trim().isEmpty()) {
                out.println("Nickname cannot be empty");
            } else if(clients.containsKey(nickName)) {
                out.println("Nickname is already in use");
            } else {
                nickName = nickName.trim();
                clients.putIfAbsent(nickName, clientSocket);
                this.clientNick = nickName;
                System.out.println("New client with Nickname: " + nickName);
                System.out.println("TCP Clients: " + clients.size());
                return;


            }
        }
    }

    private void sendToAll(String msg) {
        synchronized (clients) {
            for (Socket client : clients.values()) {
                if (client != null && !client.equals(clientSocket)) {
                    try {
                        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                        out.println(clientNick + " : " + msg);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }


            }
        }
    }

    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            chooseNick(out, in);
            out.println("Connected");
            while (true) {
                String msg = in.readLine();
                if (msg != null && !msg.trim().isEmpty()) {
                    if (msg.equals("/q")) {
                        break;
                    }
                    sendToAll(msg);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (clientNick != null) {
                clients.remove(clientNick);
            }
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("TCP Clients: " + clients.size());

    }
}
