import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_2564 {

    static byte[] b = { -78, 38, 122, 55, 90, -84, 33, -8, -91, 79 };

    static int ofs = 3;

    static int len = 1440755211;

    static MessageDigest md = null;

    static boolean isUsed = false;

    int engineUpdate(byte[] b, int ofs, int len) {
        isUsed = true;
        md.update(b, ofs, len);
        return ofs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2564().engineUpdate(b, ofs, len);
    }
}
