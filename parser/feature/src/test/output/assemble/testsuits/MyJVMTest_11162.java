import java.net.*;
import java.io.*;
import java.util.*;

public class MyJVMTest_11162 {

    static int osParam1 = 708;

    static OutputStream os = new ByteArrayOutputStream(osParam1);

    static int start = 557762990;

    static Enumeration ifs = null;

    static Class filter = null;

    static Runnable runnee = null;

    static long delay = -9223372036854775808L;

    static String osname = ":?^8EH2'tA";

    byte[] simpleWrite(OutputStream os, int start) throws Exception {
        byte[] b = new byte[2];
        for (int i = start; i < start + 100; i++) {
            b[0] = (byte) (i / 256);
            b[1] = (byte) (i % 256);
            os.write(b);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11162().simpleWrite(os, start);
    }
}
