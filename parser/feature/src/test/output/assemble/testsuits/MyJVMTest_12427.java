import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_12427 {

    static boolean separateServerThread = true;

    static boolean serverReady = false;

    static boolean useSSL = true;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    void doClientSide() throws Exception {
        while (!serverReady) {
            Thread.sleep(50);
        }
        Socket socket;
        if (useSSL) {
            SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
            socket = (SSLSocket) sslsf.createSocket("localhost", serverPort);
        } else
            socket = new Socket("localhost", serverPort);
        InputStream sslIS = socket.getInputStream();
        OutputStream sslOS = socket.getOutputStream();
        sslOS.write(80);
        sslOS.flush();
        int read = sslIS.read();
        System.out.println("client read: " + read);
        socket.close();
        boolean isSocketClosedThrown = false;
        try {
            sslOS.write(22);
            sslOS.flush();
        } catch (SSLException | SocketException socketClosed) {
            System.out.println("Received \"" + socketClosed.getMessage() + "\" exception as expected");
            isSocketClosedThrown = true;
        }
        if (!isSocketClosedThrown) {
            throw new Exception("No Exception thrown on write() after" + " close()");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12427().doClientSide();
    }
}
