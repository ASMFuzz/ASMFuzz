import java.io.*;
import java.net.*;
import javax.net.*;
import javax.net.ssl.*;

public class MyJVMTest_11986 {

    static boolean separateServerThread = true;

    static boolean useSSL = true;

    static boolean serverReady = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    void doServerSide() throws Exception {
        Socket socket;
        ServerSocket serverSocket;
        if (useSSL) {
            SSLServerSocketFactory sslssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslssf.createServerSocket(serverPort);
        } else {
            serverSocket = (ServerSocket) ServerSocketFactory.getDefault().createServerSocket(serverPort);
        }
        serverPort = serverSocket.getLocalPort();
        serverReady = true;
        try {
            socket = serverSocket.accept();
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            System.out.println("Server getChannel(): " + socket.getChannel());
            try {
                socket.setOOBInline(true);
            } catch (IOException success) {
            }
            try {
                System.out.println("Server getOOBInline(): " + socket.getOOBInline());
            } catch (IOException success) {
            }
            System.out.println("Server read: " + is.read());
            os.write(85);
            os.flush();
            socket.close();
        } catch (Exception unexpected) {
            throw new Exception(" test failed, caught exception: " + unexpected);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11986().doServerSide();
    }
}
