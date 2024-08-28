import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_8032 {

    static String[] CLIENT_SUITES = new String[] { "SSL_DH_anon_WITH_3DES_EDE_CBC_SHA" };

    static boolean serverReady = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    void doClientSide() throws Exception {
        while (!serverReady) {
            Thread.sleep(80);
        }
        SSLSocket sslSocket = null;
        try {
            SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
            sslSocket = (SSLSocket) sslsf.createSocket("localhost", serverPort);
            sslSocket.setEnabledCipherSuites(CLIENT_SUITES);
            InputStream sslIS = sslSocket.getInputStream();
            OutputStream sslOS = sslSocket.getOutputStream();
            System.out.println("Client starting handshake...");
            try {
                sslIS.read();
                throw new Exception("No handshake exception on client side");
            } catch (IOException e) {
                System.out.println("Handshake failed on client side, OK");
            }
            for (int i = 0; i < 3; i++) {
                try {
                    int ch;
                    if ((ch = sslIS.read()) != -1) {
                        throw new Exception("Read succeeded on client side: " + ch);
                    }
                } catch (IOException e) {
                    System.out.println("Exception for read() on client, OK");
                }
            }
        } finally {
            sslSocket.close();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8032().doClientSide();
    }
}
