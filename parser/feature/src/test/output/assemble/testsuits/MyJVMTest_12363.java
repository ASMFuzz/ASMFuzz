import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_12363 {

    static String s = "vh-j9Ub-0d";

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

    static String alg = "kviLHW8!jZ";

    static byte[] input = {-104,90,4,30,86,-82,-7,54,-3,-77};

    static byte[] macvalue = {24,-101,-125,-8,-106,-38,118,-73,-45,40};

    static byte[] key = {0,39,15,61,-98,23,-113,91,1,105};

    static byte[] ALONG = {-120,125,-113,-60,-56,118,8,35,-48,-128}, BLONG = {-121,-106,-113,-63,-89,108,-81,-103,-56,-32}, BKEY = {83,110,-117,-85,-9,74,104,28,70,-69};

    static byte[] BKEY_20 = {28,-20,-125,-80,-27,-89,-62,-80,-19,99}, DDDATA_50 = {33,96,-5,80,86,0,-93,-82,-123,-93}, AAKEY_20 = {-63,-45,-6,-58,113,30,66,-64,-69,-127}, CDDATA_50 = {-61,57,67,-29,-71,-24,43,-61,-15,63}, AAKEY_131 = {40,38,118,77,-25,-25,-108,42,21,116};

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
        System.out.println(Arrays.asList(new MyJVMTest_12363().parse(s)));
    }
}
