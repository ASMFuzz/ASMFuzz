import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_11150 {

    static boolean separateServerThread = true;

    static boolean serverReady = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    void doClientSide() throws Exception {
        System.out.println("    Client starting");
        while (!serverReady) {
            Thread.sleep(50);
        }
        SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try {
            System.out.println("        Client creating socket");
            SSLSocket sslSocket = (SSLSocket) sslsf.createSocket("localhost", serverPort);
            System.out.println("        Client starting handshake");
            sslSocket.startHandshake();
            throw new Exception("Handshake was successful");
        } catch (SSLException e) {
            System.out.println("       Client reported correct exception");
            System.out.println("       " + e.toString());
        } catch (Exception e) {
            System.out.println("        Client reported the wrong exception");
            throw e;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11150().doClientSide();
    }
}
