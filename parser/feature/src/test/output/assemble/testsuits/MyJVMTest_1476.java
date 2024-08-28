import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;

public class MyJVMTest_1476 {

    static InetAddress sParam1 = null;

    static int sParam2 = 335;

    static boolean sParam3 = false;

    static Socket s = new Socket(sParam1, sParam2, sParam3);

    static PrintStream log = System.err;

    Socket dump(Socket s) {
        log.println("getInetAddress(): " + s.getInetAddress());
        log.println("getPort(): " + s.getPort());
        log.println("getLocalAddress(): " + s.getLocalAddress());
        log.println("getLocalPort(): " + s.getLocalPort());
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1476().dump(s);
    }
}
