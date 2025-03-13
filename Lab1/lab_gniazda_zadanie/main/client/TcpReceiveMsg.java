package client;

import java.io.BufferedReader;
import java.io.IOException;

public class TcpReceiveMsg implements Runnable {
    private final BufferedReader in;

    public TcpReceiveMsg(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            String line;
            while (true) {
                line = in.readLine();
                if (line != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
