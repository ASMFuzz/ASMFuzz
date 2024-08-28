import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_14319 {

    static boolean separateServerThread = false;

    static boolean serverReady = false;

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
        final InputStream sslIS = sslSocket.getInputStream();
        final OutputStream sslOS = sslSocket.getOutputStream();
        new Thread(new Runnable() {

            public void run() {
                try {
                    System.out.println("Closing Thread started");
                    Thread.sleep(3000);
                    System.out.println("Closing Thread closing");
                    sslIS.close();
                } catch (Exception e) {
                    RuntimeException rte = new RuntimeException("Check this out");
                    rte.initCause(e);
                    throw rte;
                }
            }
        }).start();
        try {
            System.out.println("Client starting read");
            sslIS.read();
        } catch (IOException e) {
        }
        sslSocket.close();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14319().run();
    }
}
