import javax.net.*;
import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.net.*;
import java.util.*;

public class MyJVMTest_1925 {

    void waitForSignal() {
        while (!signal) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        signal = false;
    }

    static boolean go = true;

    static boolean signal = false;

    static int port = 0;

    static boolean started = false;

    void run() {
        try {
            SSLContext sc = SSLContext.getDefault();
            ServerSocketFactory fac = sc.getServerSocketFactory();
            SSLServerSocket ssock = (SSLServerSocket) fac.createServerSocket(0);
            this.port = ssock.getLocalPort();
            waitForSignal();
            started = true;
            while (go) {
                try {
                    System.out.println("Waiting for connection");
                    Socket sock = ssock.accept();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                    String line = reader.readLine();
                    System.out.println("server read: " + line);
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
                    out.println(line);
                    out.flush();
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
        new MyJVMTest_1925().run();
    }
}
