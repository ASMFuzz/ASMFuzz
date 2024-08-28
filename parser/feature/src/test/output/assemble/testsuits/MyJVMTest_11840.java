import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_11840 {

    static byte[] b = { 22, 105, 82, -85, -103, -42, -116, -1, -103, -5 };

    static int ofs = 1207671684;

    static int len = -1091319625;

    static MessageDigest md = null;

    static boolean isUsed = false;

    int engineUpdate(byte[] b, int ofs, int len) {
        isUsed = true;
        md.update(b, ofs, len);
        return ofs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11840().engineUpdate(b, ofs, len);
    }
}
