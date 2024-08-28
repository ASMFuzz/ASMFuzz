import java.io.*;
import javax.net.ssl.*;

public class MyJVMTest_15882 {

    void doClientSide() throws Exception {
        while (!serverReady) {
            Thread.sleep(50);
        }
        SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) sslsf.createSocket("localhost", serverPort);
        sslSocket.setEnabledCipherSuites(cliEnabledCipherSuites);
        InputStream sslIS = sslSocket.getInputStream();
        OutputStream sslOS = sslSocket.getOutputStream();
        sslOS.write(280);
        sslOS.flush();
        sslIS.read();
        sslSocket.close();
    }

    static boolean separateServerThread = false;

    static boolean serverReady = false;

    static String[] cliEnabledCipherSuites = {"3^_U)OvQ\\]","m@AefzNalU","2u?%deW|CP","u^!DD\"Np!t","G$UNmz'kx%","5hD3!d`_7h","E|Bax6Dm*[","\\q#\\>&eA '","1XnP~HS@J|","]b-366_BU>"};

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    void run() {
        try {
            doClientSide();
        } catch (Exception e) {
            System.err.println("Client died...");
            clientException = e;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15882().run();
    }
}
