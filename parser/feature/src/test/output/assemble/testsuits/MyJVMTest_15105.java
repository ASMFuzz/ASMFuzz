import java.io.*;
import java.net.*;
import java.rmi.server.*;

public class MyJVMTest_15105 {

    static int port = 6;

    static String test = ".n/~{=69[*";

    static boolean throwException = false;

    ServerSocket createServerSocket(int port) throws IOException {
        if (throwException) {
            throw new RuntimeException(test);
        } else {
            System.out.println("Calling createServerSocket(" + port + ")");
            ServerSocket ss = new ServerSocket(port);
            System.out.println("ServerSocket = " + ss);
            return ss;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15105().createServerSocket(port));
    }
}
