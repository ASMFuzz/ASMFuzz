import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;

public class MyJVMTest_6678 {

    static String DEFAULT_ALGO = "PBEWithMD5AndDES";

    static byte[] key = {18,9,84,105,114,97,-40,112,-123,48};

    static String algorithm = "N|gU=&\\aK\\";

    static int keySize = 0;

    byte[] getEncoded() {
        byte[] copy = new byte[keySize];
        System.arraycopy(key, 0, copy, 0, keySize);
        return copy;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_6678().getEncoded()));
    }
}
