import java.io.*;
import javax.net.ssl.*;

public class MyJVMTest_6399 {

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

    static boolean separateServerThread = false;

    static boolean serverReady = false;

    static String[] cliEnabledCipherSuites = {"TvjVa(!/R<","m#+c(Gs+5s","|H?=<'k6a}",".7Nf`UP~r&","OYxl7u5DHo","wS6=9LS:0=","H\\.z!T_rxY","Uk;;&A Q!<","h*aaGsqg!(","^*r@pY\\{WX"};

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    void run() {
        try {
            doClientSide();
        } catch (Exception e) {
            System.err.println("Client died...");
            clientException = e;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6399().run();
    }
}
