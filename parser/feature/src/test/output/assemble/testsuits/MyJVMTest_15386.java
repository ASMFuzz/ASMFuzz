import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_15386 {

    static byte[] src = { 28, -77, 127, 36, 100, -98, -115, -25, 123, -57 };

    static int offset = 0;

    static int len = -1878061343;

    static int failed = 0;

    static Cipher c = null;

    byte[] updateAADPass(byte[] src, int offset, int len) {
        try {
            c.updateAAD(src, offset, len);
        } catch (UnsupportedOperationException e) {
        } catch (IllegalStateException ise) {
        } catch (Exception e) {
            e.printStackTrace();
            failed++;
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15386().updateAADPass(src, offset, len);
    }
}
