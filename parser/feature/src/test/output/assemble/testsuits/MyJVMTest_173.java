import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_173 {

    static boolean separateServerThread = true;

    static boolean serverReady = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    Socket acceptUnbound() throws Exception {
        SSLServerSocketFactory sslssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        System.out.println("Server: Will create unbound SSL server socket...");
        ServerSocket sslServerSocket = sslssf.createServerSocket();
        if (sslServerSocket.isBound())
            throw new Exception("Server socket is already bound!");
        sslServerSocket.bind(new java.net.InetSocketAddress(0));
        if (!sslServerSocket.isBound())
            throw new Exception("Server socket is not bound!");
        serverPort = sslServerSocket.getLocalPort();
        System.out.println("Server: Bound SSL server socket to port " + serverPort + "...");
        serverReady = true;
        System.out.println("Server: Will accept on SSL server socket...");
        Socket sslSocket = sslServerSocket.accept();
        sslServerSocket.close();
        return sslSocket;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_173().acceptUnbound());
    }
}
