import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_17341 {

    void doServerSide() throws Exception {
        SSLServerSocketFactory sslssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslssf.createServerSocket(serverPort, 3);
        sslServerSocket.setNeedClientAuth(true);
        sslServerSocket.setEnabledCipherSuites(new String[] { suite1, suite2 });
        serverPort = sslServerSocket.getLocalPort();
        serverReady = true;
        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
        DataInputStream sslIS = new DataInputStream(sslSocket.getInputStream());
        DataOutputStream sslOS = new DataOutputStream(sslSocket.getOutputStream());
        while (true) {
            try {
                System.out.println("Received: " + sslIS.readUTF());
            } catch (SSLException e) {
                System.out.println("Received wrong exception");
                break;
            } catch (IOException e) {
                System.out.println("Received right exception");
                break;
            }
        }
        sslSocket.close();
    }

    static String suite1 = "SSL_RSA_WITH_NULL_MD5";

    static String suite2 = "SSL_RSA_WITH_NULL_SHA";

    static boolean separateServerThread = false;

    static boolean serverReady = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

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
                        serverReady = true;
                        serverException = e;
                    }
                }
            };
            serverThread.start();
        } else {
            try {
                doServerSide();
            } catch (Exception e) {
                serverException = e;
            } finally {
                serverReady = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17341().run();
    }
}
