import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class MyJVMTest_2492 {

    static DatagramChannel dc = null;

    static Exception e = null;

    void throwException() throws Exception {
        if (e != null)
            throw e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2492().throwException();
    }
}
