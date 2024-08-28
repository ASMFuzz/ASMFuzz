import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_12982 {

    static byte[] src = { -40, -23, 95, 27, -119, 26, 112, -109, -92, 106 };

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
        new MyJVMTest_12982().updateAADPass(src);
    }
}
