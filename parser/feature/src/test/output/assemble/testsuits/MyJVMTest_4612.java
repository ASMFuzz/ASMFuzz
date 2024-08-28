import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_4612 {

    static int style = -1378661506;

    Socket acceptNormally0() throws Exception {
        SSLServerSocketFactory sslssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        System.out.println("Server: Will call createServerSocket(int)");
        ServerSocket sslServerSocket = sslssf.createServerSocket(0);
        serverPort = sslServerSocket.getLocalPort();
        System.out.println("Server: Will accept on SSL server socket...");
        serverReady = true;
        Socket sslSocket = sslServerSocket.accept();
        sslServerSocket.close();
        return sslSocket;
    }

    Socket acceptNormally1() throws Exception {
        SSLServerSocketFactory sslssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        System.out.println("Server: Will call createServerSocket(int, int)");
        ServerSocket sslServerSocket = sslssf.createServerSocket(0, 1);
        serverPort = sslServerSocket.getLocalPort();
        System.out.println("Server: Will accept on SSL server socket...");
        serverReady = true;
        Socket sslSocket = sslServerSocket.accept();
        sslServerSocket.close();
        return sslSocket;
    }

    Socket acceptNormally2() throws Exception {
        SSLServerSocketFactory sslssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        System.out.println("Server: Will call createServerSocket(int, " + " int, InetAddress)");
        ServerSocket sslServerSocket = sslssf.createServerSocket(0, 1, InetAddress.getByName("localhost"));
        serverPort = sslServerSocket.getLocalPort();
        System.out.println("Server: Will accept on SSL server socket...");
        serverReady = true;
        Socket sslSocket = sslServerSocket.accept();
        sslServerSocket.close();
        return sslSocket;
    }

    Socket acceptUnbound() throws Exception {
        SSLServerSocketFactory sslssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        System.out.println("Server: Will create unbound SSL server socket...");
        ServerSocket sslServerSocket = sslssf.createServerSocket();
        if (sslServerSocket.isBound())
            throw new Exception("Server socket is already bound!");
        sslServerSocket.bind(new java.net.InetSocketAddress(0));
        if (!sslServerSocket.isBound())
            throw new Exception("Server socket is not bound!");
        serverPort = sslServerSocket.getLocalPort();
        System.out.println("Server: Bound SSL server socket to port " + serverPort + "...");
        serverReady = true;
        System.out.println("Server: Will accept on SSL server socket...");
        Socket sslSocket = sslServerSocket.accept();
        sslServerSocket.close();
        return sslSocket;
    }

    Socket acceptLayered() throws Exception {
        SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        ServerSocket ss = new ServerSocket(0);
        serverPort = ss.getLocalPort();
        System.out.println("Server: Created normal server socket bound" + " to port " + serverPort + "...");
        System.out.println("Server: Will accept on server socket...");
        serverReady = true;
        Socket s = ss.accept();
        ss.close();
        System.out.println("Server: Will layer SSLSocket on top of" + " server socket...");
        SSLSocket sslSocket = (SSLSocket) sslsf.createSocket(s, s.getInetAddress().getHostName(), s.getPort(), true);
        sslSocket.setUseClientMode(false);
        return sslSocket;
    }

    static boolean separateServerThread = true;

    static boolean serverReady = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    Socket doServerSide(int style) throws Exception {
        Socket sslSocket = null;
        switch(style) {
            case 0:
                sslSocket = acceptNormally0();
                break;
            case 1:
                sslSocket = acceptNormally1();
                break;
            case 2:
                sslSocket = acceptNormally2();
                break;
            case 3:
                sslSocket = acceptUnbound();
                break;
            case 4:
                sslSocket = acceptLayered();
                break;
            default:
                throw new Exception("Incorrectly written test for server side!");
        }
        InputStream sslIS = sslSocket.getInputStream();
        OutputStream sslOS = sslSocket.getOutputStream();
        System.out.println("Server read: " + sslIS.read());
        sslOS.write(85);
        sslOS.flush();
        sslSocket.close();
        return sslSocket;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4612().doServerSide(style);
    }
}
