import java.io.*;
import java.net.*;
import javax.net.*;
import javax.net.ssl.*;

public class MyJVMTest_3293 {

    void doClientSide() throws Exception {
        while (!serverReady) {
            Thread.sleep(50);
        }
        Socket socket;
        if (useSSL) {
            SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
            Socket plainSocket = new Socket("localhost", serverPort);
            socket = (SSLSocket) sslsf.createSocket(plainSocket, "localhost", serverPort, true);
        } else
            socket = new Socket("localhost", serverPort);
        try {
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            System.out.println("Client isInputShutdown() " + socket.isInputShutdown());
            socket.setReuseAddress(true);
            System.out.println("Client getReuseAddress(): " + socket.getReuseAddress());
            if (!"SunOS".equals(System.getProperty("os.name"))) {
                socket.setTrafficClass(8);
                System.out.println("Client getTrafficClass(): " + socket.getTrafficClass());
            }
            os.write(237);
            os.flush();
            System.out.println("Client read: " + is.read());
            socket.close();
            System.out.println("Client isOutputShutdown() " + socket.isOutputShutdown());
        } catch (Exception unexpected) {
            throw new Exception(" test failed, caught exception: " + unexpected);
        }
    }

    static boolean separateServerThread = true;

    static boolean useSSL = true;

    static boolean serverReady = false;

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
            doClientSide();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3293().run();
    }
}
