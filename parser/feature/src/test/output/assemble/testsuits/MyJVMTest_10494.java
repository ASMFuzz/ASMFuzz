import java.io.*;
import java.net.*;
import java.util.*;
import java.security.*;
import javax.net.ssl.*;

public class MyJVMTest_10494 {

    static boolean separateServerThread = true;

    static boolean serverReady = false;

    static boolean clientClosed = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    void doClientSide() throws Exception {
        boolean caught = false;
        System.out.println("waiting on server");
        while (!serverReady) {
            Thread.sleep(50);
        }
        Thread.sleep(500);
        System.out.println("server ready");
        Socket baseSocket = new Socket("localhost", serverPort);
        baseSocket.setSoTimeout(1000);
        SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) sslsf.createSocket(baseSocket, "localhost", serverPort, false);
        System.err.println("Client starting handshake: " + System.nanoTime());
        sslSocket.startHandshake();
        System.err.println("Client handshake done: " + System.nanoTime());
        Thread.sleep(500);
        System.err.println("Client closing: " + System.nanoTime());
        sslSocket.close();
        clientClosed = true;
        System.err.println("Client closed: " + System.nanoTime());
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10494().doClientSide();
    }
}
