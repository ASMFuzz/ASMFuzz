import java.io.*;
import java.net.*;
import java.util.*;
import java.security.*;
import javax.net.ssl.*;

public class MyJVMTest_16247 {

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
        SSLSocket sslSocket = (SSLSocket) sslsf.createSocket(InetAddress.getLocalHost(), serverPort);
        sslSocket.setSoTimeout(100);
        sslSocket.getSession();
        if (!sslSocket.isClosed()) {
            throw new RuntimeException("Expected connection to be closed");
        }
        sslSocket.close();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16247().doClientSide();
    }
}
