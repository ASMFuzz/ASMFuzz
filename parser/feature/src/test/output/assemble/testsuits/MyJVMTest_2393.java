import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_2393 {

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
        SSLSocket sslSocket = (SSLSocket) sslsf.createSocket("localhost", serverPort);
        sslSocket.setUseClientMode(true);
        sslSocket.setNeedClientAuth(true);
        sslSocket.setUseClientMode(false);
        System.out.println("Using Implicit handshake, ciphersuite is: " + sslSocket.getSession().getCipherSuite());
        InputStream sslIS = sslSocket.getInputStream();
        OutputStream sslOS = sslSocket.getOutputStream();
        sslOS.write(280);
        sslOS.flush();
        sslIS.read();
        try {
            sslSocket.setUseClientMode(true);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught proper exception");
        }
        sslSocket.close();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2393().doClientSide();
    }
}
