import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_784 {

    static String rParam1 = "\\a\\BF*r\"(t";

    static StringReader r = new StringReader(rParam1);

    static String alg = "MgYN+30Kt0";

    static byte[] plaintext = {-117,21,-12,55,33,-105,-24,16,106,42};

    static byte[] ciphertext = {66,-107,-128,-26,44,23,-120,3,9,17};

    static char[] password = {'O',Character.MAX_VALUE,'0',Character.MAX_VALUE,'K',Character.MIN_VALUE,Character.MIN_VALUE,Character.MAX_VALUE,Character.MIN_VALUE,'0'};

    static byte[] salt = {-64,-125,4,-53,-44,-26,89,1,-120,13};

    static int ic = -1308238172;

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
        System.out.println(new MyJVMTest_784().nextNibble(r));
    }
}
