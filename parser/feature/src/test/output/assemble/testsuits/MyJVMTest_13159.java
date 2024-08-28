import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.math.*;
import java.util.*;

public class MyJVMTest_13159 {

    static String hexVal = "pT`4V4Z+4f";

    static SecretKey key = null;

    static byte[] plainText = {47,99,6,-85,40,-118,21,4,-109,111};

    static byte[] aad = {19,-107,124,49,40,30,104,-128,31,12};

    static byte[] cipherText = {117,11,105,-95,-92,75,76,-10,-104,-52};

    static byte[] tag = {-42,-14,31,-12,-48,-65,-104,37,-51,63};

    static GCMParameterSpec spec = null;

    static String info = "LhI}^&p!oO";

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
        System.out.println(Arrays.asList(new MyJVMTest_13159().HexToBytes(hexVal)));
    }
}
