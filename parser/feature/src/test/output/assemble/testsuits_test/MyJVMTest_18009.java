import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_18009 {

    static SSLSocketFactory sslsf = null;

    static boolean needClientAuth = false;

    static boolean separateServerThread = true;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    SSLSocket communicate(SSLSocketFactory sslsf, boolean needClientAuth) throws Exception {
        SSLSocket sslSocket = (SSLSocket) sslsf.createSocket("localhost", serverPort);
        sslSocket.setNeedClientAuth(needClientAuth);
        InputStream sslIS = sslSocket.getInputStream();
        OutputStream sslOS = sslSocket.getOutputStream();
        sslOS.write(280);
        sslOS.flush();
        sslIS.read();
        sslSocket.close();
        return sslSocket;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18009().communicate(sslsf, needClientAuth);
    }
}
