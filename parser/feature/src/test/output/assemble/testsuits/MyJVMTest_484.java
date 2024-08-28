import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_484 {

    static boolean separateServerThread = true;

    static boolean serverReady = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    Socket connectNormally3() throws Exception {
        SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        System.out.println("Client: Will call createSocket(InetAddress," + " int, InetAddress, int)");
        return sslsf.createSocket(InetAddress.getByName("localhost"), serverPort, InetAddress.getByName("localhost"), 0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_484().connectNormally3());
    }
}
