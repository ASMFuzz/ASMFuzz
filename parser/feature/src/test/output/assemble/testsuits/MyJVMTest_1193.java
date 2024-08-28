import java.io.*;
import java.net.*;
import java.util.*;
import java.security.*;
import javax.net.ssl.*;

public class MyJVMTest_1193 {

    void doServerSide() throws Exception {
        SSLServerSocketFactory sslssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslssf.createServerSocket(serverPort);
        serverPort = sslServerSocket.getLocalPort();
        serverReady = true;
        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
        InputStream sslIS = sslSocket.getInputStream();
        OutputStream sslOS = sslSocket.getOutputStream();
        sslSocket.startHandshake();
        String transFilename = System.getProperty("test.src", "./") + "/" + this.getClass().getName() + ".java";
        MessageDigest md = MessageDigest.getInstance("SHA");
        DigestInputStream transIns = new DigestInputStream(new FileInputStream(transFilename), md);
        byte[] bytes = new byte[2000];
        int i = 0;
        while (true) {
            if (i >= bytes.length) {
                i = 0;
            }
            int length = 0;
            if ((length = transIns.read(bytes, 0, i++)) == -1) {
                break;
            } else {
                sslOS.write(bytes, 0, length);
                sslOS.flush();
                if (i % 3 == 0) {
                    Thread.sleep(300);
                }
            }
        }
        serverDigest = md.digest();
        transIns.close();
        sslSocket.close();
    }

    static boolean separateServerThread = true;

    static boolean serverReady = false;

    static MyInputStream ins = null;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static byte[] serverDigest = null;

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
        new MyJVMTest_1193().run();
    }
}
