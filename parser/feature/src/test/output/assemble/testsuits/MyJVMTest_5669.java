import java.io.*;
import java.net.*;
import java.rmi.server.*;

public class MyJVMTest_5669 {

    static int port = 0;

    static String test = "+g\"VnS% 9(";

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
        System.out.println(new MyJVMTest_5669().createServerSocket(port));
    }
}
