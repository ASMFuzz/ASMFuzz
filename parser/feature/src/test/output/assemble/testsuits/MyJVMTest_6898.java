import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_6898 {

    static boolean separateServerThread = true;

    static boolean serverReady = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    void doServerSide() throws Exception {
        SSLServerSocketFactory sslssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try (SSLServerSocket sslServerSocket = (SSLServerSocket) sslssf.createServerSocket(serverPort)) {
            serverPort = sslServerSocket.getLocalPort();
            serverReady = true;
            try (SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept()) {
                InputStream sslIS = sslSocket.getInputStream();
                OutputStream sslOS = sslSocket.getOutputStream();
                sslIS.read();
                sslOS.write(85);
                sslOS.flush();
                ExtendedSSLSession session = (ExtendedSSLSession) sslSocket.getSession();
                if (session.getRequestedServerNames().isEmpty()) {
                    throw new Exception("No expected Server Name Indication");
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6898().doServerSide();
    }
}
