import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_3646 {

    static byte[] src = { 23, -54, -77, 0, 43, 97, 75, -95, 4, 44 };

    static int failed = 0;

    static Cipher c = null;

    byte[] updateAADPass(byte[] src) {
        try {
            c.updateAAD(src);
        } catch (UnsupportedOperationException e) {
        } catch (IllegalStateException ise) {
        } catch (Exception e) {
            e.printStackTrace();
            failed++;
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3646().updateAADPass(src);
    }
}
