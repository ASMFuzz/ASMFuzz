import java.io.*;
import java.util.*;

public class MyJVMTest_3054 {

    static int n = 0;

    static int max = -1758753861;

    String paddedHexString(int n, int max) {
        char[] c = Integer.toHexString(n).toCharArray();
        char[] out = new char[max];
        for (int i = 0; i < max; i++) {
            out[i] = '0';
        }
        int offset = (max - c.length < 0) ? 0 : max - c.length;
        for (int i = 0; i < c.length; i++) {
            out[offset + i] = c[i];
        }
        return new String(out);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3054().paddedHexString(n, max));
    }
}
