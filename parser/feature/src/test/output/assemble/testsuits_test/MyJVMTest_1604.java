import java.io.*;
import java.net.*;
import java.util.*;
import java.security.*;
import javax.net.ssl.*;

public class MyJVMTest_1604 {

    void doClientSide() throws Exception {
        boolean caught = false;
        while (!serverReady) {
            Thread.sleep(50);
        }
        SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) sslsf.createSocket("localhost", serverPort);
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
            int length = transIns.read(bytes, 0, i++);
            if (length == -1) {
                break;
            } else {
                sslOS.write(bytes, 0, length);
                sslOS.flush();
                if (i % 3 == 0) {
                    Thread.sleep(300);
                }
            }
        }
        clientDigest = md.digest();
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

    void startClient(boolean newThread) throws Exception {
        if (newThread) {
            clientThread = new Thread() {

                public void run() {
                    try {
                        doClientSide();
                    } catch (Exception e) {
                        System.err.println("Client died...");
                        clientException = e;
                    }
                }
            };
            clientThread.start();
        } else {
            doClientSide();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1604().run();
    }
}
