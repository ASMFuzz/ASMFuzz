import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_10126 {

    void doServerSide() throws Exception {
        System.out.println("starting Server");
        SSLServerSocketFactory sslssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslssf.createServerSocket(serverPort);
        serverPort = sslServerSocket.getLocalPort();
        System.out.println("got server socket");
        serverReady = true;
        try {
            System.out.println("Server socket accepting...");
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            System.out.println("Server starting handshake");
            sslSocket.startHandshake();
            throw new Exception("Handshake was successful");
        } catch (SSLException e) {
            System.out.println("Server reported the right exception");
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println("Server reported the wrong exception");
            throw e;
        }
    }

    static boolean separateServerThread = true;

    static boolean serverReady = false;

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
        new MyJVMTest_10126().run();
    }
}
