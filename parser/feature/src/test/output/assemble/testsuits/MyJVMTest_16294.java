import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_16294 {

    void checkSNIInSession(ExtendedSSLSession session) throws Exception {
        List<SNIServerName> sessionSNI = session.getRequestedServerNames();
        if (sessionSNI.isEmpty()) {
            throw new Exception("unexpected empty request server name indication");
        }
        if (sessionSNI.size() != 1) {
            throw new Exception("unexpected request server name indication");
        }
        SNIServerName serverName = sessionSNI.get(0);
        if (!(serverName instanceof SNIHostName)) {
            throw new Exception("unexpected instance of request server name indication");
        }
        String hostname = ((SNIHostName) serverName).getAsciiName();
        if (!clientRequestedHostname.equalsIgnoreCase(hostname)) {
            throw new Exception("unexpected request server name indication value");
        }
    }

    static boolean separateServerThread = true;

    static boolean serverReady = false;

    static String clientRequestedHostname = "www.example.com";

    static String serverAcceptableHostname = "www\\.example\\.com";

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
            ExtendedSSLSession session = (ExtendedSSLSession) sslSocket.getSession();
            checkSNIInSession(session);
        } finally {
            sslSocket.close();
            sslServerSocket.close();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16294().doServerSide();
    }
}
