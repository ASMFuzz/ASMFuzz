import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.math.*;
import java.util.*;

public class MyJVMTest_5693 {

    static String hexVal = ")Z/4I\\,>^!";

    static int id = 0;

    static SecretKey key = null;

    static byte[] plainText = {-5,-82,-18,-71,-43,63,-3,-124,106,-91};

    static byte[] aad = {69,0,-15,126,-90,81,-91,-65,65,113};

    static byte[] cipherText = {-8,9,111,-45,117,75,-117,-84,44,16};

    static byte[] tag = {27,66,-9,-20,-124,-41,8,23,77,-102};

    static GCMParameterSpec spec = null;

    static String info = "Eej)sb_U]u";

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
        System.out.println(Arrays.asList(new MyJVMTest_5693().HexToBytes(hexVal)));
    }
}
