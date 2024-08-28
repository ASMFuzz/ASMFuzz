import java.security.InvalidKeyException;
import java.util.Arrays;

public class MyJVMTest_12733 {

    static byte[] key = {85,16,-88,95,-116,-26,12,43,60,-42};

    static byte[] salt = {-46,114,-11,-31,113,-105,-86,112,-27,99};

    static String algorithm = "3>laT%f(N_";

    static int keySize = 2, keyLength = 0;

    static int itereationCount = 1;

    static String pass = "dqU[yx\"Bv ";

    char[] getPassword() {
        return this.pass.toCharArray();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_12733().getPassword()));
    }
}
