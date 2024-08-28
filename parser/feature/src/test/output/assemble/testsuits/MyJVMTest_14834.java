import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_14834 {

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
        InputStream sslIS = sslSocket.getInputStream();
        OutputStream sslOS = sslSocket.getOutputStream();
        sslOS.write(280);
        sslOS.flush();
        sslIS.read();
        sslSocket.close();
        try {
            sslSocket.startHandshake();
            throw new Exception("TEST FAILED:  didn't throw SSLException");
        } catch (IOException e) {
            System.out.println("TEST PASSED:  Caught right Exception");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14834().doClientSide();
    }
}
