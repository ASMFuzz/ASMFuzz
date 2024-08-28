import java.io.*;
import javax.net.ssl.*;

public class MyJVMTest_10431 {

    static boolean separateServerThread = true;

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
        String[] enabledSuites = { "SSL_RSA_WITH_RC4_128_MD5", "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", "SSL_RSA_WITH_RC4_128_SHA", "SSL_DHE_DSS_WITH_DES_CBC_SHA" };
        sslSocket.setEnabledCipherSuites(enabledSuites);
        System.out.println("");
        System.out.println("client enabled suites: ");
        System.out.println("======================");
        String[] suites = sslSocket.getEnabledCipherSuites();
        for (int i = 0; i < suites.length; i++) System.out.println(suites[i]);
        System.out.println("");
        InputStream sslIS = sslSocket.getInputStream();
        OutputStream sslOS = sslSocket.getOutputStream();
        sslOS.write(80);
        sslOS.flush();
        int read = sslIS.read();
        System.out.println("client read: " + read);
        sslSocket.close();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10431().doClientSide();
    }
}
