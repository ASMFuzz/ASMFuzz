import java.io.*;
import java.net.*;
import java.security.*;
import javax.net.ssl.*;
import java.security.cert.*;

public class MyJVMTest_13868 {

    static SSLSocket sslSocket = null;

    static boolean separateServerThread = true;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    SSLSocket doTest(SSLSocket sslSocket) throws Exception {
        InputStream sslIS = sslSocket.getInputStream();
        OutputStream sslOS = sslSocket.getOutputStream();
        System.out.println("  Writing");
        sslOS.write(280);
        sslOS.flush();
        System.out.println("  Reading");
        sslIS.read();
        sslSocket.close();
        return sslSocket;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13868().doTest(sslSocket);
    }
}
