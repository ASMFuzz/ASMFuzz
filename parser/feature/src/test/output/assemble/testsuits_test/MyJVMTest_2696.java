import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class MyJVMTest_2696 {

    static int port = 0;

    static Exception e = null;

    void run() {
        try {
            DatagramChannel dc = DatagramChannel.open();
            ByteBuffer bb = ByteBuffer.allocateDirect(256);
            bb.put("hello".getBytes());
            bb.flip();
            InetAddress address = InetAddress.getLocalHost();
            InetSocketAddress isa = new InetSocketAddress(address, port);
            dc.send(bb, isa);
            Thread.sleep(50);
            dc.send(bb, isa);
        } catch (Exception ex) {
            e = ex;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2696().run();
    }
}
