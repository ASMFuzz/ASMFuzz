import java.security.InvalidKeyException;
import java.util.Arrays;

public class MyJVMTest_13776 {

    static byte[] key = {120,85,85,125,59,-99,15,-103,-75,-128};

    static byte[] salt = {56,65,92,41,29,126,1,-110,-10,-69};

    static String algorithm = "?qA]B/bQi(";

    static int keyLength = 7;

    static String pass = "$|hgR23b^r";

    static int itereationCount = 0;

    byte[] getEncoded() {
        byte[] copy = new byte[keyLength];
        System.arraycopy(key, 0, copy, 0, keyLength);
        return copy;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_13776().getEncoded()));
    }
}
