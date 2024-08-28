import java.io.*;
import java.util.*;
import java.security.*;

public class MyJVMTest_15213 {

    static String s = "-L1CAyg%Mb";

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

    static String alg = "*:~Dy5`7^O";

    static byte[] data = {-128,-53,-26,-4,69,-81,-11,35,-78,35};

    static byte[] digest = {3,-82,37,40,-102,102,-16,28,119,-21};

    static byte[] ALONG = {44,14,73,22,27,67,10,117,100,-124}, BLONG = {-78,-85,90,87,-50,15,-97,104,-18,96};

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
        System.out.println(Arrays.asList(new MyJVMTest_15213().parse(s)));
    }
}
