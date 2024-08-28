import java.io.*;
import sun.security.util.*;

public class MyJVMTest_7926 {

    static byte[] a = { 84, 27, -116, 85, -126, -55, 5, -46, -30, 27 };

    static byte[] b = { -34, -92, -57, -86, -39, -110, -19, -73, -118, 9 };

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
        System.out.println(new MyJVMTest_7926().equalBytes(a, b));
    }
}
