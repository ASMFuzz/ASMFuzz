import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_2777 {

    static byte[] src = { -119, 70, -60, 76, 54, -49, 30, 120, -96, -90 };

    static int offset = 4;

    static int len = 8;

    static int failed = 0;

    static Cipher c = null;

    byte[] updateAADFail(byte[] src, int offset, int len) {
        try {
            c.updateAAD(src, offset, len);
            new Exception("Didn't Fail as Expected").printStackTrace();
            failed++;
        } catch (IllegalArgumentException e) {
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2777().updateAADFail(src, offset, len);
    }
}
