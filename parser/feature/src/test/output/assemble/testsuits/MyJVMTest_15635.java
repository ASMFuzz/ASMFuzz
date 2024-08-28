import java.io.*;
import java.net.*;
import java.rmi.server.*;

public class MyJVMTest_15635 {

    static String host = "jMPK[mldvw";

    static int port = 0;

    static String test = "1btNpN]\"L<";

    static boolean throwException = false;

    Socket createSocket(String host, int port) throws IOException {
        if (throwException) {
            throw new RuntimeException(test);
        } else {
            System.out.println("Calling createSocket(" + host + "," + port + ")");
            Socket s = new Socket(host, port);
            System.out.println("Socket = " + s);
            return s;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15635().createSocket(host, port));
    }
}
