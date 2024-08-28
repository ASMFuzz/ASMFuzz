import java.io.*;
import java.net.*;
import java.lang.ref.*;
import java.rmi.*;
import java.rmi.server.*;

public class MyJVMTest_12071 {

    static int port = 5;

    ServerSocket createServerSocket(int port) throws IOException {
        return new ServerSocket(port);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12071().createServerSocket(port));
    }
}
