import java.net.*;
import java.io.*;
import java.util.*;

public class MyJVMTest_5789 {

    static byte b1 = 127;

    static byte b2 = 0;

    static Enumeration ifs = null;

    static Class filter = null;

    static Runnable runnee = null;

    static long delay = 9223372036854775807L;

    static String osname = "zUwy@GDEx&";

    int bytes(byte b1, byte b2) {
        int i1 = (int) b1 & 0xFF;
        int i2 = (int) b2 & 0xFF;
        return i1 * 256 + i2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5789().bytes(b1, b2));
    }
}
