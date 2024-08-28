import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_8602 {

    static String s = "Rh9$6w<-FZ";

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

    static String alg = "*EnQ;j{i++";

    static byte[] plaintext = {103,-1,-27,9,96,-101,-126,122,105,-128};

    static byte[] ciphertext = {-12,63,33,-57,-111,113,-28,-64,-72,110};

    static char[] password = {Character.MIN_VALUE,'X','9','E',Character.MIN_VALUE,'?',Character.MAX_VALUE,Character.MIN_VALUE,Character.MAX_VALUE,'0'};

    static byte[] salt = {-84,-44,-63,-60,116,31,-85,123,-86,-110};

    static int ic = 641869870;

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
        System.out.println(Arrays.asList(new MyJVMTest_8602().parse(s)));
    }
}
