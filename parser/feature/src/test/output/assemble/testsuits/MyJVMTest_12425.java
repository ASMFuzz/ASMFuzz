import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class MyJVMTest_12425 {

    static PrintStream log = System.err;

    static int port = 5;

    static Exception e = null;

    static DatagramSocket ds = null;

    static DatagramChannel dc = null;

    void run() {
        try {
            byte[] buf = new byte[256];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            ds.receive(dp);
            String received = new String(dp.getData());
            log.println(received);
            ds.close();
        } catch (Exception ex) {
            e = ex;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12425().run();
    }
}
