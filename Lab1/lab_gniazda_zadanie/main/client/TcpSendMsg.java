package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpSendMsg implements Runnable {
    private final PrintWriter out;

    public TcpSendMsg(PrintWriter out) {
        this.out = out;
    }

    @Override
    public void run() {
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        try {
            String msg;
            while(true){
                msg = userInput.readLine();
                out.println(msg);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
