import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import java.security.cert.*;

public class MyJVMTest_2945 {

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
        Socket socket = new Socket("localhost", serverPort);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        in.read();
        out.write(280);
        out.flush();
        SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) sslsf.createSocket(socket, socket.getInetAddress().getHostName(), socket.getPort(), true);
        sslSocket.setUseClientMode(true);
        InputStream sslIS = sslSocket.getInputStream();
        OutputStream sslOS = sslSocket.getOutputStream();
        sslIS.read();
        sslOS.write(280);
        sslOS.flush();
        sslIS.close();
        sslOS.close();
        sslSocket.close();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2945().doClientSide();
    }
}
