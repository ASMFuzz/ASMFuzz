import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.Arrays;

public class MyJVMTest_10003 {

    static byte[] a = { -56, -3, 12, -120, -112, -93, -70, -13, 111, 84 };

    static int aOff = 0;

    static byte[] b = { -49, -114, -123, -7, 67, 28, 95, -126, 38, -119 };

    static int bOff = 0;

    static int len = 0;

    boolean isTwoArraysEqual(byte[] a, int aOff, byte[] b, int bOff, int len) {
        for (int i = 0; i < len; i++) {
            if (a[aOff + i] != b[bOff + i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10003().isTwoArraysEqual(a, aOff, b, bOff, len));
    }
}
