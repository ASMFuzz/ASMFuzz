import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_12431 {

    void doServerSide() throws Exception {
        SSLContext context = SSLContext.getInstance("TLS");
        SSLServerSocketFactory sslssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslssf.createServerSocket(serverPort);
        serverPort = sslServerSocket.getLocalPort();
        serverReady = true;
        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
        sslSocket.setNeedClientAuth(true);
        InputStream sslIS = sslSocket.getInputStream();
        OutputStream sslOS = sslSocket.getOutputStream();
        sslIS.read();
        sslOS.write(85);
        sslOS.flush();
        sslSocket.close();
    }

    static boolean separateServerThread = true;

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
            System.err.println("Server died..." + e);
            e.printStackTrace();
            serverReady = true;
            serverException = e;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12431().run();
    }
}
