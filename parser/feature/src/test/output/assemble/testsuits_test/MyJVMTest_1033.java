import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_1033 {

    static boolean separateServerThread = true;

    static boolean serverReady = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    Socket connectUnconnected() throws Exception {
        SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        System.out.println("Client: Will call createSocket()");
        Socket sslSocket = sslsf.createSocket();
        if (sslSocket.isConnected())
            throw new Exception("Client socket is already connected!");
        System.out.println("Client: Will connect to server on port " + serverPort + "...");
        sslSocket.connect(new java.net.InetSocketAddress("localhost", serverPort));
        if (!sslSocket.isConnected())
            throw new Exception("Client socket is not connected!");
        return sslSocket;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1033().connectUnconnected());
    }
}
