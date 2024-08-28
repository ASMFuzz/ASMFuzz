import java.security.*;
import java.util.Arrays;

public class MyJVMTest_1603 {

    static MessageDigest digest = null;

    byte[] engineDigest() {
        return digest.digest();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_1603().engineDigest()));
    }
}
