import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.Arrays;

public class MyJVMTest_824 {

    static byte[] a = { -7, 21, 116, 100, -120, -91, 27, -122, 85, 24 };

    static int aOff = 2;

    static byte[] b = { -44, -27, 38, 6, 106, 70, 36, 29, -6, -54 };

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
        System.out.println(new MyJVMTest_824().isTwoArraysEqual(a, aOff, b, bOff, len));
    }
}
