import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_4005 {

    static String s = "w=%B;Iuk;2";

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

    static char SEP = ':';

    static String alg = "3lq))WQrc+";

    static byte[] input = {-127,98,42,66,-119,-86,32,68,104,10};

    static byte[] macvalue = {49,-96,-68,-93,105,-17,-6,-100,66,-9};

    static byte[] key = {-2,80,98,23,32,5,110,6,-74,120};

    static byte[] ALONG = {63,39,-121,18,-72,-79,-28,-40,-30,36}, BLONG = {-41,-38,-106,88,-106,6,116,-47,5,-115}, DDDATA_50 = {-47,-27,54,110,39,-73,100,91,40,-57}, CDDATA_50 = {-116,-94,54,101,-96,-123,61,-24,-36,76};

    static byte[] STR_HI_THERE = {97,69,-9,-33,-60,-18,-19,124,82,-81}, STR_WHAT_DO_YA_WANT = {-89,14,66,-56,74,-97,77,68,50,43};

    static byte[] STR_TEST_USING1 = {-110,-31,-64,-11,100,105,-113,119,-33,53}, STR_TEST_USING2 = {-99,-57,8,-116,60,31,-103,23,-58,59};

    static byte[] STR_NIST1 = {-127,-35,3,81,-101,-87,94,-22,-77,-115}, STR_NIST2 = {20,5,12,100,98,39,4,77,40,-68}, STR_NIST3 = {18,102,-82,4,-60,-49,20,59,103,67};

    static byte[] BKEY = {-127,82,-61,-101,-51,4,-33,12,-97,-32}, BKEY_20 = {-125,99,86,116,-80,74,7,126,60,-88}, CKEY_20 = {67,86,109,32,-57,97,-8,64,84,-120};

    static byte[] AAKEY_20 = {-64,-126,-78,30,-18,126,19,19,126,24}, AAKEY_131 = {-96,67,32,93,107,-7,112,-14,109,-5}, AAKEY_147 = {78,-73,39,-26,-54,9,64,57,101,95}, INCKEY_25 = {89,-57,48,125,69,39,120,44,-8,110};

    byte[] parse(String s) {
        try {
            int n = s.length();
            ByteArrayOutputStream out;
            if (s.indexOf(SEP) == -1) {
                out = new ByteArrayOutputStream(n / 2);
            } else {
                out = new ByteArrayOutputStream(n / 3);
            }
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
        System.out.println(Arrays.asList(new MyJVMTest_4005().parse(s)));
    }
}
