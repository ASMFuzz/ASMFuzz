import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class MyJVMTest_240 {

    static DatagramChannel dc = null;

    static Exception e = null;

    int port() {
        return dc.socket().getLocalPort();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_240().port());
    }
}
