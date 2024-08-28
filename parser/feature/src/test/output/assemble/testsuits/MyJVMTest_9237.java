import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_9237 {

    static int style = 0;

    Socket connectNormally0() throws Exception {
        SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        System.out.println("Client: Will call createSocket(String, int)");
        return sslsf.createSocket("localhost", serverPort);
    }

    Socket connectNormally1() throws Exception {
        SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        System.out.println("Client: Will call createSocket(InetAddress, int)");
        return sslsf.createSocket(InetAddress.getByName("localhost"), serverPort);
    }

    Socket connectNormally2() throws Exception {
        SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        System.out.println("Client: Will call createSocket(String," + " int, InetAddress, int)");
        return sslsf.createSocket("localhost", serverPort, InetAddress.getByName("localhost"), 0);
    }

    Socket connectNormally3() throws Exception {
        SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        System.out.println("Client: Will call createSocket(InetAddress," + " int, InetAddress, int)");
        return sslsf.createSocket(InetAddress.getByName("localhost"), serverPort, InetAddress.getByName("localhost"), 0);
    }

    Socket connectUnconnected() throws Exception {
        SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        System.out.println("Client: Will call createSocket()");
        Socket sslSocket = sslsf.createSocket();
        if (sslSocket.isConnected())
            throw new Exception("Client socket is already connected!");
        System.out.println("Client: Will connect to server on port " + serverPort + "...");
        sslSocket.connect(new java.net.InetSocketAddress("localhost", serverPort));
        if (!sslSocket.isConnected())
            throw new Exception("Client socket is not connected!");
        return sslSocket;
    }

    Socket connectLayered() throws Exception {
        SSLSocketFactory sslsf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        System.out.println("Client: Will connect to server on port " + serverPort + "...");
        Socket s = new Socket("localhost", serverPort);
        System.out.println("Client: Will layer SSL socket on top...");
        return sslsf.createSocket(s, "localhost", serverPort, true);
    }

    static boolean separateServerThread = true;

    static boolean serverReady = false;

    static int serverPort = 0;

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    Socket doClientSide(int style) throws Exception {
        Socket sslSocket = null;
        while (!serverReady) {
            Thread.sleep(50);
        }
        switch(style) {
            case 0:
                sslSocket = connectNormally0();
                break;
            case 1:
                sslSocket = connectNormally1();
                break;
            case 2:
                sslSocket = connectNormally2();
                break;
            case 3:
                sslSocket = connectNormally3();
                break;
            case 4:
                sslSocket = connectUnconnected();
                break;
            case 5:
                sslSocket = connectLayered();
                break;
            default:
                throw new Exception("Incorrectly written test for client side!");
        }
        InputStream sslIS = sslSocket.getInputStream();
        OutputStream sslOS = sslSocket.getOutputStream();
        sslOS.write(280);
        sslOS.flush();
        System.out.println("Client read: " + sslIS.read());
        sslSocket.close();
        return sslSocket;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9237().doClientSide(style);
    }
}
