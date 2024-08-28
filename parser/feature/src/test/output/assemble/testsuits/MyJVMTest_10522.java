import java.io.*;
import java.net.*;
import java.util.*;
import java.security.*;
import javax.net.ssl.*;

public class MyJVMTest_10522 {

    void doServerSide() throws Exception {
        SSLServerSocketFactory sslssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslssf.createServerSocket(serverPort);
        serverPort = sslServerSocket.getLocalPort();
        serverReady = true;
        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
        InputStream sslIS = sslSocket.getInputStream();
        OutputStream sslOS = sslSocket.getOutputStream();
        sslSocket.startHandshake();
        MessageDigest md = MessageDigest.getInstance("SHA");
        DigestInputStream transIns = new DigestInputStream(sslIS, md);
        byte[] bytes = new byte[2000];
        sslSocket.setSoTimeout(100);
        while (true) {
            try {
                while (transIns.read(bytes, 0, 17) != -1) ;
                break;
            } catch (SocketTimeoutException e) {
                System.out.println("Server inputStream Exception: " + e.getMessage());
            }
        }
        while (clientDigest == null) {
            Thread.sleep(20);
        }
        byte[] srvDigest = md.digest();
        if (!Arrays.equals(clientDigest, srvDigest)) {
            throw new Exception("Application data trans error");
        }
        transIns.close();
        sslSocket.close();
    }

    static boolean separateServerThread = true;

    static boolean serverReady = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static byte[] clientDigest = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    void startServer(boolean newThread) throws Exception {
        if (newThread) {
            serverThread = new Thread() {

                public void run() {
                    try {
                        doServerSide();
                    } catch (Exception e) {
                        System.err.println("Server died...");
                        System.err.println(e);
                        serverReady = true;
                        serverException = e;
                    }
                }
            };
            serverThread.start();
        } else {
            doServerSide();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10522().run();
    }
}
