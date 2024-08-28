import java.security.*;

public class MyJVMTest_5706 {

    static byte[] b1 = { -6, -112, -61, -21, 63, 58, -103, 60, -36, -128 };

    static int off1 = -1101698128;

    static byte[] b2 = { 101, 77, 38, 85, 83, -49, -107, -19, -127, -16 };

    static int off2 = 0;

    static int len = 0;

    boolean equalsBlock(byte[] b1, int off1, byte[] b2, int off2, int len) {
        for (int i = off1, j = off2, k = 0; k < len; i++, j++, k++) {
            if (b1[i] != b2[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5706().equalsBlock(b1, off1, b2, off2, len));
    }
}
