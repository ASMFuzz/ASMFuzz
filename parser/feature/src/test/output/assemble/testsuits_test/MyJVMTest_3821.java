import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_3821 {

    static boolean separateServerThread = false;

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
        InputStream sslIS = sslSocket.getInputStream();
        OutputStream sslOS = sslSocket.getOutputStream();
        sslIS.read(new byte[0], 0, 0);
        sslOS.write(new byte[0], 0, 0);
        sslIS.read(new byte[1], 0, 0);
        sslOS.write(new byte[1], 0, 0);
        SSLSession sess = sslSocket.getSession();
        if (!sess.isValid()) {
            throw new Exception("Error occurs during the initial handshake");
        }
        sslIS.close();
        sslOS.close();
        sslSocket.close();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3821().doClientSide();
    }
}
