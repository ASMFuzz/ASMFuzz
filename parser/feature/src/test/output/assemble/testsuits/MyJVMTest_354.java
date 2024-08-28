import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_354 {

    static boolean separateServerThread = false;

    static boolean serverReady = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static boolean isAbbreviated = false;

    static String tlsProtocol = "hAzT0q3*;I";

    static Thread clientThread = null;

    static Thread serverThread = null;

    void doClientSide() throws Exception {
        while (!serverReady) {
            Thread.sleep(50);
        }
        SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) sslsf.createSocket("localhost", serverPort);
        sslSocket.setEnabledProtocols(new String[] { tlsProtocol });
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
        new MyJVMTest_354().doClientSide();
    }
}
