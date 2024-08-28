import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_2952 {

    static byte input = 0;

    static MessageDigest md = null;

    static boolean isUsed = false;

    byte engineUpdate(byte input) {
        isUsed = true;
        md.update(input);
        return input;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2952().engineUpdate(input);
    }
}
