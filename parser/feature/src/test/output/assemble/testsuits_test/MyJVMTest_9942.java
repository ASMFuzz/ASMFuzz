import java.io.*;
import java.net.*;
import java.lang.ref.*;
import java.rmi.*;
import java.rmi.server.*;

public class MyJVMTest_9942 {

    static int port = 0;

    static Remote obj = null;

    ServerSocket createServerSocket(int port) throws IOException {
        return new ServerSocket(port);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9942().createServerSocket(port));
    }
}
