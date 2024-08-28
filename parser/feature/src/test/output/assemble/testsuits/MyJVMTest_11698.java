import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_11698 {

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
        for (int i = 0; i < 10; i++) {
            sslOS.write(280);
            sslOS.flush();
            sslIS.read();
        }
        sslSocket.close();
    }

    static byte handshakesCompleted = 0;

    static boolean separateServerThread = false;

    static boolean serverReady = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    void run() {
        try {
            doClientSide();
        } catch (Exception e) {
            System.err.println("Client died...");
            clientException = e;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11698().run();
    }
}
