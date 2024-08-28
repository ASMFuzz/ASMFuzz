import java.security.InvalidKeyException;
import java.util.Arrays;

public class MyJVMTest_3403 {

    static byte[] key = {32,103,-87,-124,0,8,27,43,-62,-10};

    static byte[] salt = {-7,66,4,117,-112,54,108,-115,-99,-127};

    static String algorithm = "-S:j41*8-{";

    static int keySize = 0, keyLength = 0;

    static int itereationCount = 1;

    static String pass = "4Es={/V7`w";

    char[] getPassword() {
        return this.pass.toCharArray();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_3403().getPassword()));
    }
}
