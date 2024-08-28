import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_17852 {

    static String suite1 = "SSL_RSA_WITH_NULL_MD5";

    static String suite2 = "SSL_RSA_WITH_NULL_SHA";

    static boolean separateServerThread = false;

    static boolean serverReady = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    void doClientSide() throws Exception {
        while (!serverReady) {
            Thread.sleep(50);
        }
        SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) sslsf.createSocket("localhost", serverPort);
        sslSocket.setEnabledCipherSuites(new String[] { suite1 });
        System.out.println("Enabled " + suite1);
        DataInputStream sslIS = new DataInputStream(sslSocket.getInputStream());
        DataOutputStream sslOS = new DataOutputStream(sslSocket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        sslOS.writeUTF("With " + suite1);
        sslSocket.setEnabledCipherSuites(new String[] { suite2 });
        sslSocket.startHandshake();
        System.out.println("Enabled " + suite2);
        sslOS.writeUTF("With " + suite2);
        sslOS.writeUTF("With " + suite2);
        sslOS.writeUTF("With " + suite2);
        sslSocket.setEnabledCipherSuites(new String[] { suite1 });
        sslSocket.startHandshake();
        System.out.println("Re-enabled " + suite1);
        sslOS.writeUTF("With " + suite1);
        sslOS.writeUTF("With " + suite1);
        sslOS.writeUTF("With " + suite1);
        sslSocket.close();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17852().doClientSide();
    }
}
