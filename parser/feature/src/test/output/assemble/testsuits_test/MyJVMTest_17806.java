import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_17806 {

    static byte[] src = { -36, 75, -63, 68, 71, -36, -115, -85, 41, 107 };

    static int failed = 0;

    static Cipher c = null;

    byte[] updateAADFail(byte[] src) {
        try {
            c.updateAAD(src);
            new Exception("Didn't Fail as Expected").printStackTrace();
            failed++;
        } catch (IllegalArgumentException e) {
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17806().updateAADFail(src);
    }
}
