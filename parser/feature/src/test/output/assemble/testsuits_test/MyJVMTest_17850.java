import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_17850 {

    static boolean separateServerThread = true;

    static boolean serverReady = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    Socket connectLayered() throws Exception {
        SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        System.out.println("Client: Will connect to server on port " + serverPort + "...");
        Socket s = new Socket("localhost", serverPort);
        System.out.println("Client: Will layer SSL socket on top...");
        return sslsf.createSocket(s, "localhost", serverPort, true);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17850().connectLayered());
    }
}
