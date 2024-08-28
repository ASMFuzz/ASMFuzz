import java.io.*;
import java.util.*;
import java.security.*;

public class MyJVMTest_16283 {

    static String rParam1 = "~zV(T(PpyD";

    static StringReader r = new StringReader(rParam1);

    static String alg = "EB(vB{2/@X";

    static byte[] data = {122,-50,-79,-107,47,43,96,-13,-42,120};

    static byte[] digest = {-68,-24,83,92,53,85,-125,106,-90,-113};

    static byte[] ALONG = {-31,81,-121,-38,-114,48,-98,86,61,74}, BLONG = {-38,-71,41,-41,79,26,-48,7,-119,10};

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
        System.out.println(new MyJVMTest_16283().nextNibble(r));
    }
}
