import java.security.InvalidKeyException;
import java.util.Arrays;

public class MyJVMTest_10964 {

    static byte[] key = {82,-38,-105,126,-107,117,-118,39,71,-61};

    static byte[] salt = {-87,3,-107,-112,108,90,41,-43,-29,-114};

    static String algorithm = "u/Z:Job]A$";

    static int keyLength = 8;

    static String pass = "$%R4hqQQX}";

    static int itereationCount = 0;

    char[] getPassword() {
        return pass.toCharArray();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_10964().getPassword()));
    }
}
