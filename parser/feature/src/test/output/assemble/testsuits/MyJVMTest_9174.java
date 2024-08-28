import java.io.*;
import java.net.*;
import java.util.*;
import java.security.*;
import javax.net.ssl.*;

public class MyJVMTest_9174 {

    void doServerSide() throws Exception {
        SSLServerSocketFactory sslssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslssf.createServerSocket(serverPort);
        serverPort = sslServerSocket.getLocalPort();
        serverReady = true;
        System.err.println("Server accepting: " + System.nanoTime());
        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
        System.err.println("Server accepted: " + System.nanoTime());
        sslSocket.startHandshake();
        System.err.println("Server handshake complete: " + System.nanoTime());
        while (!clientClosed) {
            Thread.sleep(500);
        }
    }

    static boolean separateServerThread = true;

    static boolean serverReady = false;

    static boolean clientClosed = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    void run() {
        try {
            doServerSide();
        } catch (Exception e) {
            System.err.println("Server died...");
            System.err.println(e);
            serverReady = true;
            serverException = e;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9174().run();
    }
}
