import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;

public class MyJVMTest_16174 {

    static String DEFAULT_ALGO = "PBEWithMD5AndDES";

    static byte[] key = {105,80,-127,-63,-17,-40,-11,58,84,-110};

    static String algorithm = "\\LQWS9%Du.";

    static int keySize = 9;

    byte[] getEncoded() {
        byte[] copy = new byte[keySize];
        System.arraycopy(key, 0, copy, 0, keySize);
        return copy;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_16174().getEncoded()));
    }
}
