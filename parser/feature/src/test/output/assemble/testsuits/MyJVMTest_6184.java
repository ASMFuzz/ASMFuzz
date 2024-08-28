import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_6184 {

    static byte[] a = { 12, -34, 16, 12, -112, 105, -93, 4, 69, 66 };

    static int capacity = 7;

    static String name = "TBtCr(WWgT";

    static byte[] data = {-12,-23,66,36,50,89,-93,117,115,7};

    static int level = 2;

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
        System.out.println(Arrays.asList(new MyJVMTest_6184().grow(a, capacity)));
    }
}
