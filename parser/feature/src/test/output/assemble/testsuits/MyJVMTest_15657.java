import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_15657 {

    static byte[] a = { 27, 42, 25, -57, 114, -10, -120, -20, 70, 105 };

    static int capacity = 0;

    static String name = "BW<~W{WDwC";

    static byte[] data = {102,-84,-97,-68,113,-87,-72,-63,52,-82};

    static int level = 0;

    static int STRIDE = 1024;

    byte[] grow(byte[] a, int capacity) {
        while (a.length < capacity) {
            byte[] a2 = new byte[a.length * 2];
            System.arraycopy(a, 0, a2, 0, a.length);
            a = a2;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_15657().grow(a, capacity)));
    }
}
