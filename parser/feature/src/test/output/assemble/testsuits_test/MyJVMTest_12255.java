import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_12255 {

    static byte input = 107;

    static MessageDigest md = null;

    static boolean isUsed = false;

    byte engineUpdate(byte input) {
        isUsed = true;
        md.update(input);
        return input;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12255().engineUpdate(input);
    }
}
