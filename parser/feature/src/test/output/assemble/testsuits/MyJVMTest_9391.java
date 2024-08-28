import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class MyJVMTest_9391 {

    static DatagramChannel dc = null;

    static Exception e = null;

    int port() {
        return dc.socket().getLocalPort();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9391().port());
    }
}
