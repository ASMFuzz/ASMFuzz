import java.io.*;
import javax.net.ssl.*;

public class MyJVMTest_12214 {

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
        String[] enabledSuites = { "SSL_RSA_WITH_DES_CBC_SHA", "SSL_DHE_DSS_WITH_DES_CBC_SHA", "SSL_RSA_WITH_RC4_128_MD5" };
        sslSocket.setEnabledCipherSuites(enabledSuites);
        System.out.println("");
        System.out.println("server enabled suites: ");
        System.out.println("=====================");
        String[] suites = sslSocket.getEnabledCipherSuites();
        for (int i = 0; i < suites.length; i++) System.out.println(suites[i]);
        System.out.println("");
        InputStream sslIS = sslSocket.getInputStream();
        OutputStream sslOS = sslSocket.getOutputStream();
        int read = sslIS.read();
        System.out.println("Server read: " + read);
        sslOS.write(85);
        sslOS.flush();
        String cipherSuiteChosen = sslSocket.getSession().getCipherSuite();
        System.out.println("Cipher suite in use: " + cipherSuiteChosen);
        sslSocket.close();
        if (!cipherSuiteChosen.equals("SSL_RSA_WITH_RC4_128_MD5"))
            throw new Exception("Test failed: Wrong cipher suite is chosen");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12214().doServerSide();
    }
}
