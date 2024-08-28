import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_4519 {

    static boolean separateServerThread = true;

    static boolean serverReady = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    Socket acceptNormally0() throws Exception {
        SSLServerSocketFactory sslssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        System.out.println("Server: Will call createServerSocket(int)");
        ServerSocket sslServerSocket = sslssf.createServerSocket(0);
        serverPort = sslServerSocket.getLocalPort();
        System.out.println("Server: Will accept on SSL server socket...");
        serverReady = true;
        Socket sslSocket = sslServerSocket.accept();
        sslServerSocket.close();
        return sslSocket;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4519().acceptNormally0());
    }
}
