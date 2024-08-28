import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_15351 {

    static boolean separateServerThread = true;

    static boolean serverReady = false;

    static String serverAcceptableHostname = "www\\.example\\.org";

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    void doServerSide() throws Exception {
        SSLServerSocketFactory sslssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslssf.createServerSocket(serverPort);
        SNIMatcher matcher = SNIHostName.createSNIMatcher(serverAcceptableHostname);
        Collection<SNIMatcher> matchers = new ArrayList<>(1);
        matchers.add(matcher);
        SSLParameters params = sslServerSocket.getSSLParameters();
        params.setSNIMatchers(matchers);
        sslServerSocket.setSSLParameters(params);
        serverPort = sslServerSocket.getLocalPort();
        serverReady = true;
        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
        try {
            InputStream sslIS = sslSocket.getInputStream();
            OutputStream sslOS = sslSocket.getOutputStream();
            sslIS.read();
            sslOS.write(85);
            sslOS.flush();
            throw new Exception("Mismatched server name indication was accepted");
        } catch (SSLHandshakeException sslhe) {
        } catch (IOException ioe) {
        } finally {
            sslSocket.close();
            sslServerSocket.close();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15351().doServerSide();
    }
}
