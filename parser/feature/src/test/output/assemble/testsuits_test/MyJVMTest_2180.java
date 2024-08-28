import java.io.*;
import javax.net.ssl.*;

public class MyJVMTest_2180 {

    static boolean separateServerThread = false;

    static boolean serverReady = false;

    static String[] srvEnabledCipherSuites = {"Ux\\V'+`0y>","%R|#KE_t[U","+@fSSrkkm+","+Xe||`FDH+","[\\VST!jd }","(I-G&.j*le","U.|>A@}oIC","w%Uu%*z_yn","0,_ar7?0<?","\\`p9t0;#6N"};

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
        new MyJVMTest_2180().doServerSide();
    }
}
