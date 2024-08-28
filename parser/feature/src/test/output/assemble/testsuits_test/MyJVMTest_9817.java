import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class MyJVMTest_9817 {

    static int port = 1;

    static Exception e = null;

    static DatagramSocket ds = null;

    static DatagramChannel dc = null;

    int port() {
        return ds.getLocalPort();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9817().port());
    }
}
