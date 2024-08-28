import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_13509 {

    void doClientSide() throws Exception {
        while (!serverReady) {
            Thread.sleep(50);
        }
        SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try (SSLSocket sslSocket = (SSLSocket) sslsf.createSocket()) {
            sslSocket.connect(new InetSocketAddress(hostname, serverPort), 0);
            InputStream sslIS = sslSocket.getInputStream();
            OutputStream sslOS = sslSocket.getOutputStream();
            sslOS.write(280);
            sslOS.flush();
            sslIS.read();
        }
    }

    static boolean separateServerThread = true;

    static boolean serverReady = false;

    static String hostname = null;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    void startClient(boolean newThread) throws Exception {
        if (newThread) {
            clientThread = new Thread() {

                public void run() {
                    try {
                        doClientSide();
                    } catch (Exception e) {
                        System.err.println("Client died...");
                        clientException = e;
                    }
                }
            };
            clientThread.start();
        } else {
            try {
                doClientSide();
            } catch (Exception e) {
                clientException = e;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13509().run();
    }
}
