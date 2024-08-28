import java.io.*;
import java.net.*;
import java.util.*;
import java.security.*;
import javax.net.ssl.*;
import java.security.cert.*;

public class MyJVMTest_10681 {

    static String[][] protocolStrings = { { "TLSv1" }, { "TLSv1", "SSLv2Hello" }, { "TLSv1", "SSLv3" }, { "SSLv3", "SSLv2Hello" }, { "SSLv3" }, { "TLSv1", "SSLv3", "SSLv2Hello" } };

    static boolean[][] eXceptionArray = { { false, true, false, true, true, true }, { false, false, false, true, true, false }, { false, true, false, true, false, true }, { true, true, false, false, false, false }, { true, true, false, true, false, true }, { false, false, false, false, false, false } };

    static String[][] protocolSelected = { { "TLSv1", null, "TLSv1", null, null, null }, { "TLSv1", "TLSv1", "TLSv1", null, null, "TLSv1" }, { "TLSv1", null, "TLSv1", null, "SSLv3", null }, { null, null, "SSLv3", "SSLv3", "SSLv3", "SSLv3" }, { null, null, "SSLv3", null, "SSLv3", null }, { "TLSv1", "TLSv1", "TLSv1", "SSLv3", "SSLv3", "TLSv1" } };

    static boolean serverReady = false;

    static int serverPort = 0;

    static Exception clientException = null;

    static String[] enabledP = null;

    static SSLServerSocket sslServerSocket = null;

    static int numExpConns = -1086913620;

    static boolean stopRequested = false;

    static boolean exceptionExpected = false;

    static String[] serverP = null;

    static String protocolToUse = null;

    void run() {
        int conns = 0;
        while (!stopRequested) {
            SSLSocket socket = null;
            try {
                serverReady = true;
                socket = (SSLSocket) sslServerSocket.accept();
                conns++;
                serverReady = false;
                socket.startHandshake();
                SSLSession session = socket.getSession();
                session.invalidate();
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                out.write(280);
                in.read();
                socket.close();
                Thread.sleep(30);
            } catch (SSLHandshakeException se) {
                System.out.println("Server SSLHandshakeException:");
                se.printStackTrace(System.out);
            } catch (java.io.InterruptedIOException ioe) {
                break;
            } catch (java.lang.InterruptedException ie) {
                break;
            } catch (Exception e) {
                System.out.println("Server exception:");
                e.printStackTrace(System.out);
                throw new RuntimeException(e);
            } finally {
                try {
                    if (socket != null) {
                        socket.close();
                    }
                } catch (IOException e) {
                }
            }
            if (conns >= numExpConns) {
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10681().run();
    }
}
