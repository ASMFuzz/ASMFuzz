import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_9963 {

    static String rParam1 = "6+t43Cx@(H";

    static StringReader r = new StringReader(rParam1);

    static String alg = "CJD*Wf$aKi";

    static byte[] plaintext = {-18,6,86,-5,94,123,-10,-66,-34,7};

    static byte[] ciphertext = {65,107,46,93,-43,114,31,13,101,-44};

    static char[] password = {Character.MIN_VALUE,'0','0',Character.MAX_VALUE,Character.MIN_VALUE,'D','0',Character.MIN_VALUE,'0','I'};

    static byte[] salt = {86,-76,-107,-38,-89,-35,-87,99,-119,0};

    static int ic = 1;

    int nextNibble(StringReader r) throws IOException {
        while (true) {
            int ch = r.read();
            if (ch == -1) {
                return -1;
            } else if ((ch >= '0') && (ch <= '9')) {
                return ch - '0';
            } else if ((ch >= 'a') && (ch <= 'f')) {
                return ch - 'a' + 10;
            } else if ((ch >= 'A') && (ch <= 'F')) {
                return ch - 'A' + 10;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9963().nextNibble(r));
    }
}
