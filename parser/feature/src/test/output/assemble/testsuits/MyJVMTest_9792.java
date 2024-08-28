import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import java.security.cert.*;

public class MyJVMTest_9792 {

    static boolean separateServerThread = false;

    static boolean serverReady = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    void doServerSide() throws Exception {
        ServerSocket serverSocket = null;
        serverSocket = new ServerSocket(serverPort);
        serverPort = serverSocket.getLocalPort();
        serverReady = true;
        Socket socket = serverSocket.accept();
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();
        out.write(85);
        out.flush();
        in.read();
        SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) sslsf.createSocket(socket, socket.getInetAddress().getHostName(), socket.getPort(), true);
        sslSocket.setUseClientMode(false);
        sslSocket.setNeedClientAuth(true);
        InputStream sslIS = sslSocket.getInputStream();
        OutputStream sslOS = sslSocket.getOutputStream();
        sslOS.write(85);
        sslOS.flush();
        sslIS.read();
        System.out.println("About to get PeerCertificates");
        Certificate[] certs = sslSocket.getSession().getPeerCertificates();
        if (certs[0] instanceof X509Certificate) {
            System.out.println("Peer: " + ((X509Certificate) certs[0]).getSubjectDN());
        }
        sslIS.close();
        sslOS.close();
        sslSocket.close();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9792().doServerSide();
    }
}
