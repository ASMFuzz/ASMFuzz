import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.math.*;
import java.util.*;

public class MyJVMTest_15131 {

    static String hexVal = " W7$q-+WMf";

    static int id = 2;

    static SecretKey key = null;

    static byte[] plainText = {-3,46,-63,-54,25,82,-106,89,41,22};

    static byte[] aad = {89,-47,-66,5,-99,63,-112,108,91,4};

    static byte[] cipherText = {34,-50,83,-93,114,-13,56,-35,59,27};

    static byte[] tag = {-54,-117,119,-57,5,-59,-43,86,-66,120};

    static GCMParameterSpec spec = null;

    static String info = "!'Y/i,eVnq";

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
        System.out.println(Arrays.asList(new MyJVMTest_15131().HexToBytes(hexVal)));
    }
}
