import java.io.*;
import javax.net.ssl.*;

public class MyJVMTest_11433 {

    static boolean separateServerThread = false;

    static boolean serverReady = false;

    static String[] srvEnabledCipherSuites = {"7F7<rx.,+t","1C@xz(G]f0","m'j/!v6b~o","<;d`Os,lXF","acg]Pq5;uZ","~yaekY!c)h",".pd}%<EjkM","RY=*/I`?,+","8L2{QQ:Ir ","lmKg'cQM:r"};

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

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

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11433().doServerSide();
    }
}
