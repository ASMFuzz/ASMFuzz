import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;

public class MyJVMTest_4047 {

    static int sParam1 = 630;

    static ServerSocket s = new ServerSocket(sParam1);

    static PrintStream log = System.err;

    ServerSocket dump(ServerSocket s) {
        log.println("getInetAddress(): " + s.getInetAddress());
        log.println("getLocalPort(): " + s.getLocalPort());
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4047().dump(s);
    }
}
