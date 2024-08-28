import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_3453 {

    static boolean separateServerThread = false;

    static boolean serverReady = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static boolean isAbbreviated = false;

    static Thread clientThread = null;

    static Thread serverThread = null;

    void doClientSide() throws Exception {
        while (!serverReady) {
            Thread.sleep(50);
        }
        SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) sslsf.createSocket("localhost", serverPort);
        InputStream sslIS = sslSocket.getInputStream();
        OutputStream sslOS = sslSocket.getOutputStream();
        for (int i = 0; i < 10; i++) {
            sslOS.write(280);
            sslOS.flush();
            sslIS.read();
        }
        if (!isAbbreviated) {
            System.out.println("invalidating");
            sslSocket.getSession().invalidate();
        }
        System.out.println("starting new handshake");
        sslSocket.startHandshake();
        try {
            for (int i = 0; i < 10; i++) {
                sslOS.write(280);
                sslOS.flush();
                sslIS.read();
            }
            throw new Exception("Not reject client initialized renegotiation");
        } catch (IOException ioe) {
            System.out.println("Got the expected exception");
        } finally {
            sslSocket.close();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3453().doClientSide();
    }
}
