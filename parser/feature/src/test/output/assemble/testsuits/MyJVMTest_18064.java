import java.io.*;
import javax.net.ssl.*;

public class MyJVMTest_18064 {

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
        String[] suites = new String[] { "TLS_DHE_RSA_WITH_AES_128_CBC_SHA" };
        sslSocket.setEnabledCipherSuites(suites);
        try {
            InputStream sslIS = sslSocket.getInputStream();
            OutputStream sslOS = sslSocket.getOutputStream();
            sslOS.write(280);
            sslOS.flush();
            sslIS.read();
            throw new Exception("Leagcy DH keys (< 1024) should be restricted");
        } catch (SSLHandshakeException she) {
        } finally {
            sslSocket.close();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18064().doClientSide();
    }
}
