import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_11667 {

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
            throw new Exception("Mismatched server name indication was accepted");
        } catch (SSLHandshakeException sslhe) {
        } catch (IOException ioe) {
        } finally {
            sslSocket.close();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11667().doClientSide();
    }
}
