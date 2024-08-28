import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_4335 {

    static MessageDigest md = null;

    static boolean isUsed = false;

    void engineReset() {
        isUsed = true;
        md.reset();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4335().engineReset();
    }
}
