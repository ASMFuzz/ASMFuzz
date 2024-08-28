import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_5934 {

    static byte[] src = { -24, 2, 119, -43, -28, 20, -55, 3, -85, 125 };

    static int offset = 9;

    static int len = -431471243;

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
        new MyJVMTest_5934().updateAADPass(src, offset, len);
    }
}
