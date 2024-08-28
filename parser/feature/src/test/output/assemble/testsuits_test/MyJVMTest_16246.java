import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_16246 {

    void doClientSide() throws Exception {
        while (!serverReady) {
            Thread.sleep(50);
        }
        SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) sslsf.createSocket("localhost", serverPort);
        sslSocket.setEnabledProtocols(new String[] { serverProtocol, clientProtocol });
        InputStream sslIS = sslSocket.getInputStream();
        OutputStream sslOS = sslSocket.getOutputStream();
        for (int i = 0; i < 10; i++) {
            sslOS.write(280);
            sslOS.flush();
            sslIS.read();
        }
        for (int i = 0; i < 10; i++) {
            sslOS.write(280);
            sslOS.flush();
            sslIS.read();
        }
        sslSocket.close();
    }

    static byte handshakesCompleted = 0;

    static boolean separateServerThread = false;

    static boolean serverReady = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static String clientProtocol = "ZA0o-j9p*C";

    static String serverProtocol = "$&/PC]}QBL";

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
            doClientSide();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16246().run();
    }
}
