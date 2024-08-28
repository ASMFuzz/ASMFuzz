import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_5461 {

    static String rParam1 = "UE1Xl~{(:D";

    static StringReader r = new StringReader(rParam1);

    static String alg = "S<n_^;@OQw";

    static byte[] input = {-127,-14,-81,-126,-68,100,110,34,87,-85};

    static byte[] macvalue = {105,-22,38,-91,-117,110,-33,69,-37,-118};

    static byte[] key = {-15,119,-72,1,-64,-59,43,17,53,-14};

    static byte[] ALONG = {78,-128,-66,-94,-109,-24,88,-87,-88,-65}, BLONG = {100,116,-46,23,56,95,-114,-85,-69,31}, BKEY = {-73,-88,-82,4,-7,116,-98,-119,-89,-100};

    static byte[] BKEY_20 = {-45,123,-40,-58,121,55,109,-11,-64,-24}, DDDATA_50 = {111,117,63,-91,113,-21,-21,55,-121,-45}, AAKEY_20 = {42,23,26,-10,52,12,74,-33,80,78}, CDDATA_50 = {54,124,-75,71,-57,111,11,14,-114,60}, AAKEY_131 = {117,-117,-127,-16,-113,-85,83,-89,116,70};

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
        System.out.println(new MyJVMTest_5461().nextNibble(r));
    }
}
