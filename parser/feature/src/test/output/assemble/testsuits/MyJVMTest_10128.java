import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_10128 {

    static boolean separateServerThread = true;

    static boolean serverReady = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    void doClientSide() throws Exception {
        while (!serverReady) {
            Thread.sleep(50);
        }
        SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) sslsf.createSocket();
        InputStream sslIS;
        OutputStream sslOS;
        try {
            System.out.print("getInputStream()...");
            sslIS = sslSocket.getInputStream();
            throw new Exception("getInputStream didn't throw properly");
        } catch (SocketException e) {
            System.out.println("Caught proper exception:  " + e.toString());
        }
        try {
            System.out.print("getOutputStream()...");
            sslOS = sslSocket.getOutputStream();
            throw new Exception("getOutputStream didn't throw properly");
        } catch (SocketException e) {
            System.out.println("Caught proper exception:  " + e.toString());
        }
        try {
            System.out.print("startHandshake()...");
            sslSocket.startHandshake();
            throw new Exception("startHandshake() didn't throw properly");
        } catch (SocketException e) {
            System.out.println("Caught proper exception:  " + e.toString());
        }
        InetSocketAddress addr = new InetSocketAddress("localhost", serverPort);
        sslSocket.connect(addr, 2000);
        sslOS = sslSocket.getOutputStream();
        sslIS = sslSocket.getInputStream();
        sslOS.write(280);
        sslOS.flush();
        System.out.println("reading: " + sslIS.read());
        sslSocket.close();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10128().doClientSide();
    }
}
