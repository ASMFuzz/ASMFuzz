import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class MyJVMTest_17934 {

    static PrintStream log = System.err;

    static int port = 0;

    static Exception e = null;

    static DatagramSocket ds = null;

    static DatagramChannel dc = null;

    void run() {
        try {
            ByteBuffer bb = ByteBuffer.allocateDirect(100);
            SocketAddress sa = dc.receive(bb);
            bb.flip();
            CharBuffer cb = Charset.forName("US-ASCII").newDecoder().decode(bb);
            log.println("From: " + sa + " said " + cb);
            dc.close();
        } catch (Exception ex) {
            e = ex;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17934().run();
    }
}
