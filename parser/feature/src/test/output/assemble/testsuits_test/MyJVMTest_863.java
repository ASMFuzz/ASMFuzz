import java.io.*;
import javax.net.ssl.*;

public class MyJVMTest_863 {

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

    static String[] srvEnabledCipherSuites = {"B`'Pk;as!N","@}hc3j5OVQ",".0bB0Dz)N1","lLhu>R1 kD","u7w<wW-Kpm","fPfmJ\\RHA0","FGbt~aVXE$","rLVRgP2={{","A@q$lT6u<m","#Ia)B?2%tQ"};

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    void startServer(boolean newThread) throws Exception {
        if (newThread) {
            serverThread = new Thread() {

                public void run() {
                    try {
                        doServerSide();
                    } catch (Exception e) {
                        System.err.println("Server died...");
                        serverReady = true;
                        serverException = e;
                    }
                }
            };
            serverThread.start();
        } else {
            try {
                doServerSide();
            } catch (Exception e) {
                serverException = e;
            } finally {
                serverReady = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_863().run();
    }
}
