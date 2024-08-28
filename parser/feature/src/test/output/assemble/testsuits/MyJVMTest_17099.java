import java.io.*;
import javax.net.ssl.*;

public class MyJVMTest_17099 {

    void doServerSide() throws Exception {
        SSLServerSocketFactory sslssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslssf.createServerSocket(serverPort);
        serverPort = sslServerSocket.getLocalPort();
        SSLParameters params = sslServerSocket.getSSLParameters();
        params.setUseCipherSuitesOrder(true);
        params.setCipherSuites(srvEnabledCipherSuites);
        sslServerSocket.setSSLParameters(params);
        serverReady = true;
        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
        InputStream sslIS = sslSocket.getInputStream();
        OutputStream sslOS = sslSocket.getOutputStream();
        sslIS.read();
        sslOS.write(85);
        sslOS.flush();
        SSLSession session = sslSocket.getSession();
        if (!srvEnabledCipherSuites[0].equals(session.getCipherSuite())) {
            throw new Exception("Expected to negotiate " + srvEnabledCipherSuites[0] + " , but not " + session.getCipherSuite());
        }
        sslSocket.close();
    }

    static boolean separateServerThread = false;

    static boolean serverReady = false;

    static String[] srvEnabledCipherSuites = {"L\"YwGqMc[2","[::VK>@F92","d]dy9\\JK]2","'W8eE,Y\"U[","/q1Irb!II.","kJHgOy[f.A","wpz4aS@C%>","SXB~#NqX|}","/O.,sd!xaB",">Zrp6y{FA1"};

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    void run() {
        try {
            doServerSide();
        } catch (Exception e) {
            System.err.println("Server died...");
            serverReady = true;
            serverException = e;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17099().run();
    }
}
