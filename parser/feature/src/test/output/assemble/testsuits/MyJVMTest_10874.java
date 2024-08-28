import java.io.*;
import javax.net.ssl.*;

public class MyJVMTest_10874 {

    void doServerSide() throws Exception {
        SSLServerSocketFactory sslssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslssf.createServerSocket(serverPort);
        serverPort = sslServerSocket.getLocalPort();
        serverReady = true;
        try (SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept()) {
            InputStream sslIS = sslSocket.getInputStream();
            OutputStream sslOS = sslSocket.getOutputStream();
            sslIS.read();
            sslOS.write(85);
            sslOS.flush();
            throw new Exception("Leagcy DH keys (< 1024) should be restricted");
        } catch (SSLHandshakeException she) {
        } finally {
            sslServerSocket.close();
        }
    }

    static boolean separateServerThread = false;

    static boolean serverReady = false;

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
            serverReady = true;
            serverException = e;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10874().run();
    }
}
