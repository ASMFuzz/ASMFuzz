import java.io.*;
import java.net.*;
import java.rmi.server.*;

public class MyJVMTest_6164 {

    static String host = "P4$%MkN&*f";

    static int port = 0;

    static String test = "H%IrT'~`pX";

    static boolean throwException = true;

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
        System.out.println(new MyJVMTest_6164().createSocket(host, port));
    }
}
