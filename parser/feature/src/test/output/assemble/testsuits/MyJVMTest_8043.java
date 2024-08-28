import java.io.*;
import java.net.*;
import java.util.*;
import java.security.*;
import java.security.cert.*;
import javax.net.*;
import javax.net.ssl.*;

public class MyJVMTest_8043 {

    void doClientSide() throws Exception {
        while (!serverReady) {
            Thread.sleep(50);
        }
        KeyStore ks = KeyStore.getInstance("Windows-MY", "SunMSCAPI");
        ks.load(null, null);
        System.out.println("Loaded keystore: Windows-MY");
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(ks, null);
        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        tmf.init(ks);
        SSLContext ctx = SSLContext.getInstance("TLS");
        ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
        SSLSocketFactory sslsf = ctx.getSocketFactory();
        SSLSocket sslSocket = (SSLSocket) sslsf.createSocket("localhost", serverPort);
        if (clientProtocol != null) {
            sslSocket.setEnabledProtocols(new String[] { clientProtocol });
        }
        if (clientCiperSuite != null) {
            sslSocket.setEnabledCipherSuites(new String[] { clientCiperSuite });
        }
        InputStream sslIS = sslSocket.getInputStream();
        OutputStream sslOS = sslSocket.getOutputStream();
        sslOS.write(280);
        sslOS.flush();
        sslIS.read();
        sslSocket.close();
    }

    static boolean separateServerThread = false;

    static boolean serverReady = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static String clientProtocol = null;

    static String clientCiperSuite = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    static X509TrustManager tm = null;

    void run() {
        try {
            doClientSide();
        } catch (Exception e) {
            System.err.println("Client died...");
            clientException = e;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8043().run();
    }
}
