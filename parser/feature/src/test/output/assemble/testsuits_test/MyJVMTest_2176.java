import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_2176 {

    static boolean separateServerThread = true;

    static boolean serverReady = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    Socket connectNormally1() throws Exception {
        SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        System.out.println("Client: Will call createSocket(InetAddress, int)");
        return sslsf.createSocket(InetAddress.getByName("localhost"), serverPort);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2176().connectNormally1());
    }
}
