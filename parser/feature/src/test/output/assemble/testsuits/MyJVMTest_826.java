import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_826 {

    static byte[] b = { -81, 74, -83, -89, -71, -72, -36, 100, 113, -122 };

    static char[] hexDigits = "0123456789abcdef".toCharArray();

    static String alg = "k>K!Aq>t4x";

    static byte[] plaintext = {-85,94,119,-119,97,7,47,92,-6,30};

    static byte[] ciphertext = {100,118,15,49,-52,106,-89,-55,-64,112};

    static char[] password = {'\\',Character.MAX_VALUE,'0',Character.MIN_VALUE,'0','}',Character.MIN_VALUE,'v','0',Character.MAX_VALUE};

    static byte[] salt = {121,40,-66,75,-37,32,91,-53,86,-27};

    static int ic = 2115131157;

    String hexDump(byte[] b) {
        if (b == null) {
            return "(null)";
        }
        StringBuffer sb = new StringBuffer(b.length * 3);
        for (int i = 0; i < b.length; i++) {
            int k = b[i] & 0xff;
            if (i != 0) {
                sb.append(':');
            }
            sb.append(hexDigits[k >>> 4]);
            sb.append(hexDigits[k & 0xf]);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_826().hexDump(b));
    }
}
