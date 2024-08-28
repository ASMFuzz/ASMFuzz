import java.io.*;
import java.net.*;
import java.security.*;
import javax.net.ssl.*;

public class MyJVMTest_16856 {

    static boolean separateServerThread = true;

    static boolean serverReady = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    void doServerSide() throws Exception {
        SSLServerSocketFactory sslssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslssf.createServerSocket(serverPort, 3);
        sslServerSocket.setNeedClientAuth(true);
        serverPort = sslServerSocket.getLocalPort();
        serverReady = true;
        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
        InputStream sslIS = sslSocket.getInputStream();
        OutputStream sslOS = sslSocket.getOutputStream();
        try {
            sslIS.read();
            sslOS.write(85);
            sslOS.flush();
        } catch (SSLHandshakeException e) {
            System.out.println("Should see a null cert chain exception for server: " + e.toString());
        }
        sslSocket.close();
        System.out.println("Server done and exiting!");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16856().doServerSide();
    }
}
