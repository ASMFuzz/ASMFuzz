import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;

public class MyJVMTest_10692 {

    static String sParam1 = "OXlJy Gtlu";

    static int sParam2 = 751;

    static Socket s = new Socket(sParam1, sParam2);

    static PrintStream log = System.err;

    Socket dump(Socket s) {
        log.println("getInetAddress(): " + s.getInetAddress());
        log.println("getPort(): " + s.getPort());
        log.println("getLocalAddress(): " + s.getLocalAddress());
        log.println("getLocalPort(): " + s.getLocalPort());
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10692().dump(s);
    }
}
