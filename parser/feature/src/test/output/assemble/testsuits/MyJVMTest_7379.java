import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_7379 {

    static boolean separateServerThread = true;

    static boolean serverReady = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

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
        sslSocket.setSoTimeout(3000);
        sslOS.write(280);
        sslOS.flush();
        try {
            if (sslIS.read() == -1)
                ;
            throw new Exception("read == -1");
        } catch (SocketTimeoutException e) {
            System.out.println("Caught right exception...");
            caught = true;
            Thread.sleep(6500);
            if (sslIS.read() == 85)
                System.out.println("Read the right value");
            else
                throw new Exception("Test Failed");
        }
        if (!caught)
            throw new Exception("Didn't see exception");
        sslSocket.close();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7379().doClientSide();
    }
}
