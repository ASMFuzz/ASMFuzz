import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_12070 {

    static byte[] src = { 58, 50, 21, 101, -48, -109, 124, 99, 112, -20 };

    static int offset = 0;

    static int len = 9;

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
        new MyJVMTest_12070().updateAADFail(src, offset, len);
    }
}
