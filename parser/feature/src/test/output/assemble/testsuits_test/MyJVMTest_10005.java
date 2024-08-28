import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_10005 {

    static byte[] b = { -104, 104, 81, -73, 20, -3, 117, -68, -61, -103 };

    static char[] hexDigits = "0123456789abcdef".toCharArray();

    static String alg = ":|p|'Xx61p";

    static byte[] plaintext = {34,19,40,-104,-116,98,81,124,21,-63};

    static byte[] ciphertext = {30,103,70,77,-68,-120,8,-59,-10,-36};

    static char[] password = {Character.MAX_VALUE,Character.MAX_VALUE,Character.MAX_VALUE,Character.MAX_VALUE,'0',Character.MAX_VALUE,'3',Character.MIN_VALUE,'s',Character.MAX_VALUE};

    static byte[] salt = {104,9,-58,109,44,-42,124,-31,-42,25};

    static int ic = 5;

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
        System.out.println(new MyJVMTest_10005().hexDump(b));
    }
}
