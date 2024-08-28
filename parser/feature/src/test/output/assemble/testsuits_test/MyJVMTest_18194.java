import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_18194 {

    static String s = "[Z'H$(|x]@";

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

    static String alg = ",/T=KqksrG";

    static byte[] plaintext = {67,99,-105,98,-13,-97,33,42,21,68};

    static byte[] ciphertext = {-103,39,-111,74,-2,92,64,13,-11,-43};

    static char[] password = {Character.MIN_VALUE,'L','0',Character.MIN_VALUE,'0','2',Character.MIN_VALUE,'t',Character.MAX_VALUE,'h'};

    static byte[] salt = {-31,20,-11,127,-7,-87,-105,-80,-4,-106};

    static int ic = 0;

    byte[] parse(String s) {
        try {
            int n = s.length();
            ByteArrayOutputStream out = new ByteArrayOutputStream(n / 3);
            StringReader r = new StringReader(s);
            while (true) {
                int b1 = nextNibble(r);
                if (b1 < 0) {
                    break;
                }
                int b2 = nextNibble(r);
                if (b2 < 0) {
                    throw new RuntimeException("Invalid string " + s);
                }
                int b = (b1 << 4) | b2;
                out.write(b);
            }
            return out.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_18194().parse(s)));
    }
}
