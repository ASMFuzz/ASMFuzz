import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_8231 {

    static byte[] src = { 71, 60, 26, -86, 127, -12, -39, 121, 95, -57 };

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
        new MyJVMTest_8231().updateAADFail(src);
    }
}
