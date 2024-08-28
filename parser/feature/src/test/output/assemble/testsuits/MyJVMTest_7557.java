import java.io.*;
import javax.net.ssl.*;

public class MyJVMTest_7557 {

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

    static String[] srvEnabledCipherSuites = {"M_ej&Ci%J1","cz9PG\\6{u0","_89Vfq20hK","g?(iazenKb","N:c_ C.#lo","8ege53wN9$","I$?]W>?ldS","SKw)P=?c\"T","|0N7;J,XHi","ZNYpNU}W,x"};

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
        new MyJVMTest_7557().run();
    }
}
