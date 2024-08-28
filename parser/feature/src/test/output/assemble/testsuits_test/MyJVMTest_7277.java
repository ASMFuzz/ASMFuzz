import java.security.InvalidKeyException;
import java.util.Arrays;

public class MyJVMTest_7277 {

    static byte[] key = {116,45,26,-24,0,-54,114,124,-115,-44};

    static byte[] salt = {-96,63,114,16,-51,6,63,108,-114,77};

    static String algorithm = "r2$1/*%Gz)";

    static int keySize = 0, keyLength = 3;

    static int itereationCount = 9;

    static String pass = "KZ<AJb_{)z";

    byte[] getEncoded() {
        byte[] copy = new byte[keyLength];
        System.arraycopy(this.key, 0, copy, 0, keyLength);
        return copy;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_7277().getEncoded()));
    }
}
