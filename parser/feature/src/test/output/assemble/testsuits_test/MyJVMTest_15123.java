import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_15123 {

    static boolean separateServerThread = true;

    static boolean serverReady = false;

    static boolean useSSL = true;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    void doServerSide() throws Exception {
        ServerSocket serverSocket;
        if (useSSL) {
            SSLServerSocketFactory sslssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslssf.createServerSocket(serverPort);
        } else {
            serverSocket = new ServerSocket(serverPort);
        }
        serverPort = serverSocket.getLocalPort();
        serverReady = true;
        Socket socket = serverSocket.accept();
        InputStream sslIS = socket.getInputStream();
        OutputStream sslOS = socket.getOutputStream();
        int read = sslIS.read();
        System.out.println("Server read: " + read);
        sslOS.write(85);
        sslOS.flush();
        socket.close();
        socket.close();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15123().doServerSide();
    }
}
