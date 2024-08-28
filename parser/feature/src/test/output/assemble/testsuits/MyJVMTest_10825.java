import java.security.*;
import java.util.Arrays;

public class MyJVMTest_10825 {

    static MessageDigest digest = null;

    byte[] engineDigest() {
        return digest.digest();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_10825().engineDigest()));
    }
}
