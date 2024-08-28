import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_16098 {

    static boolean separateServerThread = true;

    static boolean serverReady = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    Socket acceptLayered() throws Exception {
        SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        ServerSocket ss = new ServerSocket(0);
        serverPort = ss.getLocalPort();
        System.out.println("Server: Created normal server socket bound" + " to port " + serverPort + "...");
        System.out.println("Server: Will accept on server socket...");
        serverReady = true;
        Socket s = ss.accept();
        ss.close();
        System.out.println("Server: Will layer SSLSocket on top of" + " server socket...");
        SSLSocket sslSocket = (SSLSocket) sslsf.createSocket(s, s.getInetAddress().getHostName(), s.getPort(), true);
        sslSocket.setUseClientMode(false);
        return sslSocket;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16098().acceptLayered());
    }
}
