import java.io.*;
import javax.net.ssl.*;

public class MyJVMTest_5118 {

    static boolean separateServerThread = false;

    static boolean serverReady = false;

    static String[] cliEnabledCipherSuites = {"5Z{G8(!/(3","1Zqq-k;faa","@\\jNQhQ0rO","NC\\\\x~'|Y:","i;Z[Asg+?G","ZJ\\yXu(R2r","&<a>*\"K~u]","s\\mZ(OR(5Z","0mQ+sd|YX8","xR\\<v|F*Y:"};

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    void doClientSide() throws Exception {
        while (!serverReady) {
            Thread.sleep(50);
        }
        SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) sslsf.createSocket("localhost", serverPort);
        sslSocket.setEnabledCipherSuites(cliEnabledCipherSuites);
        InputStream sslIS = sslSocket.getInputStream();
        OutputStream sslOS = sslSocket.getOutputStream();
        sslOS.write(280);
        sslOS.flush();
        sslIS.read();
        sslSocket.close();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5118().doClientSide();
    }
}
