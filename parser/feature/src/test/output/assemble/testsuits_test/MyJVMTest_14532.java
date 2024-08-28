import java.io.*;
import javax.net.ssl.*;

public class MyJVMTest_14532 {

    static boolean separateServerThread = false;

    static boolean serverReady = false;

    static String[] cliEnabledCipherSuites = {"f0]<</hXuD","Lv{aint!lt","J\\{^MRthJ`","G=su)Lpm5?","oO=Hs)|^o5","hiz%W7F5\\;","g);id~q)e!","N~\\!GZ!$h|","&O^=3_!HJ\"","N%o:VHM|ex"};

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
        new MyJVMTest_14532().doClientSide();
    }
}
