import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_11597 {

    static boolean separateServerThread = true;

    static boolean serverReady = false;

    static String hostname = null;

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
        try (SSLSocket sslSocket = (SSLSocket) sslsf.createSocket()) {
            sslSocket.connect(new InetSocketAddress(hostname, serverPort), 0);
            InputStream sslIS = sslSocket.getInputStream();
            OutputStream sslOS = sslSocket.getOutputStream();
            sslOS.write(280);
            sslOS.flush();
            sslIS.read();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11597().doClientSide();
    }
}
