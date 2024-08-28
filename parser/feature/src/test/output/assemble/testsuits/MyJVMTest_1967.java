import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_1967 {

    static String s = "frF;A;3A(X";

    byte[] toByteArray(String s) {
        char[] c = s.toCharArray();
        byte[] t = new byte[c.length / 2];
        int n = 0;
        int d1 = -1;
        int d2 = -1;
        for (int i = 0; i < c.length; i++) {
            char ch = c[i];
            if (d1 == -1) {
                d1 = Character.digit(ch, 16);
            } else {
                d2 = Character.digit(ch, 16);
                if (d2 != -1) {
                    t[n++] = (byte) ((d1 << 4) | d2);
                    d1 = -1;
                    d2 = -1;
                }
            }
        }
        if (d1 != -1) {
            throw new RuntimeException();
        }
        if (n == t.length) {
            return t;
        }
        byte[] b = new byte[n];
        System.arraycopy(t, 0, b, 0, n);
        return b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_1967().toByteArray(s)));
    }
}
