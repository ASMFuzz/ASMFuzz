import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class MyJVMTest_4153 {

    static int port = 731382661;

    static Exception e = null;

    static DatagramSocket ds = null;

    static DatagramChannel dc = null;

    int port() {
        return dc.socket().getLocalPort();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4153().port());
    }
}
