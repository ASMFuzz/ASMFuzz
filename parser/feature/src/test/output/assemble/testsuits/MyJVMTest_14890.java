import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_14890 {

    static String rParam1 = "{I&4$1UmnR";

    static StringReader r = new StringReader(rParam1);

    static String alg = "%DS*PR$qK\\";

    static byte[] input = {-18,-64,26,4,-92,-38,23,-105,59,116};

    static byte[] macvalue = {-69,-64,60,107,-7,60,-64,-72,68,7};

    static byte[] key = {79,22,-23,68,23,-124,-29,39,9,-81};

    static byte[] ALONG = {84,-5,-116,-60,73,-101,52,25,1,36}, BLONG = {71,-84,53,-67,-45,-90,-75,-100,-76,65}, BKEY = {-74,-38,89,110,116,-15,-44,80,-17,110};

    static byte[] BKEY_20 = {77,-17,-100,-98,42,-12,-85,-38,91,-67}, DDDATA_50 = {-108,-6,-2,6,127,-17,0,-57,-48,94}, AAKEY_20 = {118,-122,10,33,119,5,-110,-115,5,95}, CDDATA_50 = {3,-7,-121,-100,67,63,-110,16,-79,-29}, AAKEY_131 = {43,74,-16,-5,-20,-82,-46,-79,4,-126};

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
        System.out.println(new MyJVMTest_14890().nextNibble(r));
    }
}
