import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_3052 {

    static String s = "yP{wKdQ%hi";

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

    static String alg = "Wz9:wvdc}T";

    static byte[] input = {-5,-98,-58,-51,40,103,36,4,67,119};

    static byte[] macvalue = {38,46,-60,-22,-53,39,-89,-75,117,-65};

    static byte[] key = {-93,-99,-35,42,50,52,119,-82,-57,-40};

    static byte[] ALONG = {-99,59,65,34,-108,-46,-20,110,-74,123}, BLONG = {124,-80,65,-26,66,-10,-20,-50,21,68}, BKEY = {6,37,-4,-119,93,-3,57,51,-94,-23};

    static byte[] BKEY_20 = {-125,22,79,-16,73,66,47,-14,17,22}, DDDATA_50 = {76,-76,-21,-34,52,-128,62,-24,125,-26}, AAKEY_20 = {-85,-116,-102,104,13,29,77,-20,-100,-113}, CDDATA_50 = {-90,38,125,4,-5,26,-65,28,-12,41}, AAKEY_131 = {-108,-68,76,-79,74,-65,37,-127,125,39};

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
        System.out.println(Arrays.asList(new MyJVMTest_3052().parse(s)));
    }
}
