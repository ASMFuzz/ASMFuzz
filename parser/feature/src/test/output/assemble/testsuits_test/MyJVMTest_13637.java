import java.net.*;
import java.security.*;
import javax.net.ssl.*;
import java.io.*;

public class MyJVMTest_13637 {

    static String keystorefile = System.getProperty("test.src", "./") + "/../../../../../javax/net/ssl/etc/keystore";

    static String passphrase = "passphrase";

    static ServerSocket proxySocket = null;

    static Socket sockIn = null;

    static Socket sockOut = null;

    static InputStream input = null;

    static OutputStream output = null;

    static ServerSocket serverSocket = null;

    static SSLSocketFactory sslSocketFactory = null;

    SocketAddress getAddress() {
        return proxySocket.getLocalSocketAddress();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13637().getAddress());
    }
}
