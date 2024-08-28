import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_6033 {

    static byte[] a = { 70, 83, -4, 52, 124, -40, -10, -70, -80, -54 };

    static int capacity = -1989155208;

    byte[] grow(byte[] a, int capacity) {
        while (a.length < capacity) {
            byte[] a2 = new byte[a.length * 2];
            System.arraycopy(a, 0, a2, 0, a.length);
            a = a2;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_6033().grow(a, capacity)));
    }
}
