import java.net.*;
import java.security.*;
import javax.net.ssl.*;
import java.io.*;

public class MyJVMTest_9700 {

    static ServerSocket serverSocket = null;

    static SSLSocketFactory sslSocketFactory = null;

    int getPort() {
        return serverSocket.getLocalPort();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9700().getPort());
    }
}
