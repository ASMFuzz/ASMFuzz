import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.math.*;
import java.util.*;

public class MyJVMTest_3818 {

    static String hexVal = "P6$e`G~:r?";

    static SecretKey key = null;

    static byte[] plainText = {95,102,-32,-77,50,47,-119,-90,13,98};

    static byte[] aad = {99,-121,52,-85,44,32,23,-81,-80,-108};

    static byte[] cipherText = {14,13,-29,-99,2,-52,-16,-38,-98,83};

    static byte[] tag = {-68,17,-47,-102,101,121,-101,-57,-6,-6};

    static GCMParameterSpec spec = null;

    static String info = "K+UmHE]2O1";

    byte[] HexToBytes(String hexVal) {
        if (hexVal == null)
            return new byte[0];
        byte[] result = new byte[hexVal.length() / 2];
        for (int i = 0; i < result.length; i++) {
            String byteVal = hexVal.substring(2 * i, 2 * i + 2);
            result[i] = Integer.valueOf(byteVal, 16).byteValue();
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_3818().HexToBytes(hexVal)));
    }
}
