import java.security.InvalidKeyException;
import java.util.Arrays;

public class MyJVMTest_1741 {

    static byte[] key = {0,22,0,49,-80,-63,-51,87,-4,-108};

    static byte[] salt = {-78,81,112,-118,-91,55,-52,-85,-88,106};

    static String algorithm = "0h~0vV*13a";

    static int keyLength = 0;

    static String pass = "V`TZhOad\\%";

    static int itereationCount = 3;

    char[] getPassword() {
        return pass.toCharArray();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_1741().getPassword()));
    }
}
