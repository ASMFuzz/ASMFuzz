import java.io.*;
import java.util.*;
import java.security.*;

public class MyJVMTest_5770 {

    static String s = "z3{JmejZa9";

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

    static String alg = "S*.f{@_Pn?";

    static byte[] data = {26,-72,-9,100,98,-35,13,37,57,12};

    static byte[] digest = {63,-52,21,72,-46,50,7,-95,-6,-79};

    static byte[] ALONG = {-16,23,-49,42,81,64,58,29,-125,-128}, BLONG = {-99,-55,123,49,-40,-119,0,93,47,-100};

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
        System.out.println(Arrays.asList(new MyJVMTest_5770().parse(s)));
    }
}
