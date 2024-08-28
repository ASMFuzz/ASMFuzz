import java.security.InvalidKeyException;
import java.util.Arrays;

public class MyJVMTest_16801 {

    static byte[] key = {117,2,-116,-49,-19,97,100,7,99,-108};

    static byte[] salt = {127,120,-30,107,22,79,-41,-89,108,90};

    static String algorithm = "\\T)`@b~M/H";

    static int keySize = 5, keyLength = -1739783410;

    static int itereationCount = 4;

    static String pass = "&C(9%w\"tJ;";

    byte[] getEncoded() {
        byte[] copy = new byte[keyLength];
        System.arraycopy(this.key, 0, copy, 0, keyLength);
        return copy;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_16801().getEncoded()));
    }
}
