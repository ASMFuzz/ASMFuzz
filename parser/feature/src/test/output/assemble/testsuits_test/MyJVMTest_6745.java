import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class MyJVMTest_6745 {

    static DatagramSocket ds = null;

    static Exception e = null;

    int port() {
        return ds.getLocalPort();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6745().port());
    }
}
