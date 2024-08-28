import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.Arrays;

public class MyJVMTest_4311 {

    static MessageDigest md = null;

    static boolean isUsed = false;

    byte[] engineDigest() {
        isUsed = true;
        return md.digest();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_4311().engineDigest()));
    }
}
