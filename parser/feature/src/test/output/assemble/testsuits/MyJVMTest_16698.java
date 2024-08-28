import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import java.util.*;
import java.security.*;

public class MyJVMTest_16698 {

    static int serverConns = -266250757;

    static boolean separateServerThread = true;

    static boolean serverReady = false;

    static int MAX_ACTIVE_CONNECTIONS = 4;

    static int FREE_PORT = 0;

    static int[] serverPorts = new int[] { 0, 0, 0, 0 };

    static int createdPorts = 0;

    static SSLServerSocketFactory sslssf = null;

    static SSLContext sslctx = null;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    int doServerSide(int serverConns) throws Exception {
        try (SSLServerSocket sslServerSocket = (SSLServerSocket) sslssf.createServerSocket(FREE_PORT)) {
            sslServerSocket.setSoTimeout(45000);
            synchronized (serverPorts) {
                int serverPort = sslServerSocket.getLocalPort();
                System.out.printf("server #%d started on port %d%n", createdPorts, serverPort);
                serverPorts[createdPorts++] = serverPort;
                if (createdPorts == serverPorts.length) {
                    serverReady = true;
                }
            }
            int read = 0;
            int nConnections = 0;
            SSLSession[] sessions = new SSLSession[serverConns];
            SSLSessionContext sessCtx = sslctx.getServerSessionContext();
            while (nConnections < serverConns) {
                try (SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept()) {
                    sslSocket.setSoTimeout(90000);
                    InputStream sslIS = sslSocket.getInputStream();
                    OutputStream sslOS = sslSocket.getOutputStream();
                    read = sslIS.read();
                    sessions[nConnections] = sslSocket.getSession();
                    sslOS.write(85);
                    sslOS.flush();
                    nConnections++;
                }
            }
        }
        return serverConns;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16698().doServerSide(serverConns);
    }
}
