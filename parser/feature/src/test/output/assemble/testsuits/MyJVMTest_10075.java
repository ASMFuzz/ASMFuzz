import javax.net.*;
import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.net.*;
import java.util.*;

public class MyJVMTest_10075 {

    void waitForSignal() {
        while (!signal) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        signal = false;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
    }

    static boolean go = true;

    static boolean signal = false;

    static int port = 7;

    void run() {
        try {
            SSLContext sc = SSLContext.getDefault();
            waitForSignal();
            while (go) {
                try {
                    SSLSocket sock = (SSLSocket) sc.getSocketFactory().createSocket();
                    sock.connect(new InetSocketAddress("localhost", port));
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
                    out.println("message");
                    out.flush();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                    String inMsg = reader.readLine();
                    System.out.println("Client received: " + inMsg);
                    out.close();
                    sock.close();
                    waitForSignal();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10075().run();
    }
}
