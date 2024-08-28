import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_4491 {

    static boolean separateServerThread = true;

    static boolean serverReady = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    void doServerSide() throws Exception {
        SSLServerSocketFactory sslssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslssf.createServerSocket(serverPort);
        serverPort = sslServerSocket.getLocalPort();
        serverReady = true;
        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
        InputStream sslIS = sslSocket.getInputStream();
        OutputStream sslOS = sslSocket.getOutputStream();
        sslSocket.startHandshake();
        sslIS.read();
        Thread.sleep(10000);
        sslOS.write(85);
        sslOS.flush();
        sslSocket.close();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4491().doServerSide();
    }
}
