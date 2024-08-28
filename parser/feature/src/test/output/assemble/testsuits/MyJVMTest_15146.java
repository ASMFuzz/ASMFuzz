import java.security.*;

public class MyJVMTest_15146 {

    static byte[] b1 = { -70, -95, 72, -20, -34, -26, -34, -110, -9, 105 };

    static int off1 = 1162076272;

    static byte[] b2 = { 37, -41, 90, 37, -98, -56, -71, 11, -31, 95 };

    static int off2 = 848615158;

    static int len = 1;

    boolean equalsBlock(byte[] b1, int off1, byte[] b2, int off2, int len) {
        for (int i = off1, j = off2, k = 0; k < len; i++, j++, k++) {
            if (b1[i] != b2[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15146().equalsBlock(b1, off1, b2, off2, len));
    }
}
