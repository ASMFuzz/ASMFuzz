import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_15488 {

    static byte[] a = { -16, -79, -33, 4, -87, 119, 123, 73, -3, 71 };

    static int capacity = 4;

    byte[] grow(byte[] a, int capacity) {
        while (a.length < capacity) {
            byte[] a2 = new byte[a.length * 2];
            System.arraycopy(a, 0, a2, 0, a.length);
            a = a2;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_15488().grow(a, capacity)));
    }
}
