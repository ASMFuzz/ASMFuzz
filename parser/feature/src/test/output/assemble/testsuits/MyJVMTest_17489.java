import java.io.*;
import sun.security.util.*;

public class MyJVMTest_17489 {

    static byte[] a = { -39, 89, -123, 96, 36, 24, 106, -35, -123, -35 };

    static byte[] b = { 78, 56, -76, -102, -28, -42, 9, -62, -54, -73 };

    static String s = null;

    boolean equalBytes(byte[] a, byte[] b) {
        int len1 = a.length;
        int len2 = b.length;
        if (len1 != len2)
            return false;
        for (int i = 0; i < len1 && i < len2; i++) if (a[i] != b[i])
            return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17489().equalBytes(a, b));
    }
}
