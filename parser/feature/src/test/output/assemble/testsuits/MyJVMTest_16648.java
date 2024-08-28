import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_16648 {

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

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    void doClientSide() throws Exception {
        while (!serverReady) {
            Thread.sleep(50);
        }
        SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) sslsf.createSocket("localhost", serverPort);
        SNIHostName serverName = new SNIHostName(clientRequestedHostname);
        List<SNIServerName> serverNames = new ArrayList<>(1);
        serverNames.add(serverName);
        SSLParameters params = sslSocket.getSSLParameters();
        params.setServerNames(serverNames);
        sslSocket.setSSLParameters(params);
        try {
            InputStream sslIS = sslSocket.getInputStream();
            OutputStream sslOS = sslSocket.getOutputStream();
            sslOS.write(280);
            sslOS.flush();
            sslIS.read();
            ExtendedSSLSession session = (ExtendedSSLSession) sslSocket.getSession();
            checkSNIInSession(session);
        } finally {
            sslSocket.close();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16648().doClientSide();
    }
}
