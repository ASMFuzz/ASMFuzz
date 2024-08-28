import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class MyJVMTest_8192 {

    static int port = 5;

    static Exception e = null;

    static DatagramSocket ds = null;

    static DatagramChannel dc = null;

    void throwException() throws Exception {
        if (e != null)
            throw e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8192().throwException();
    }
}
