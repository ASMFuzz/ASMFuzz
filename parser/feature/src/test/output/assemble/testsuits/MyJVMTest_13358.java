import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_13358 {

    static String s = "fmi6`D|i`$";

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

    static String alg = "pZ=8^l7PQC";

    static byte[] input = {119,-49,-3,127,75,94,-59,-87,-16,-55};

    static byte[] macvalue = {-77,-26,0,-62,-26,121,123,70,-98,-70};

    static byte[] key = {49,-124,84,39,1,26,-25,59,65,4};

    static byte[] ALONG = {22,-113,-36,41,-86,20,-92,43,21,-11}, BLONG = {46,-115,110,-58,-71,-116,-105,8,-101,-36}, DDDATA_50 = {-24,119,-116,38,-47,-45,-104,19,-81,96}, CDDATA_50 = {-88,111,64,-107,-75,86,64,-39,97,10};

    static byte[] STR_HI_THERE = {-104,109,-34,-14,64,70,-73,65,40,85}, STR_WHAT_DO_YA_WANT = {-62,78,-31,78,-58,31,53,-57,-105,-35};

    static byte[] STR_TEST_USING1 = {110,-63,16,118,116,110,-29,-79,4,-92}, STR_TEST_USING2 = {104,12,30,63,106,-26,116,-73,44,25};

    static byte[] STR_NIST1 = {-82,-76,-61,14,-87,85,-94,32,-102,-13}, STR_NIST2 = {-27,8,-2,115,-44,-26,-116,108,14,-98}, STR_NIST3 = {-80,120,46,127,-111,-113,-9,64,3,-101};

    static byte[] BKEY = {-19,31,-128,-90,84,-105,25,73,-12,-119}, BKEY_20 = {-20,-111,-47,-70,32,-104,29,-57,35,-48}, CKEY_20 = {-2,-6,-93,72,-10,87,-50,-24,4,-88};

    static byte[] AAKEY_20 = {74,80,6,-125,-11,-93,100,30,93,23}, AAKEY_131 = {51,52,75,86,85,53,-19,45,-66,70}, AAKEY_147 = {57,-75,-19,34,102,-59,-95,-70,-72,-108}, INCKEY_25 = {13,98,-81,-42,-7,-110,127,-112,-42,-123};

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
        System.out.println(Arrays.asList(new MyJVMTest_13358().parse(s)));
    }
}
