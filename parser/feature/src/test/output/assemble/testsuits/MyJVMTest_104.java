import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_104 {

    static String s = "iy1u-];Ucj";

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

    static String alg = "-!}#u6wTFC";

    static byte[] plaintext = {123,102,108,-50,126,-98,9,18,-65,0};

    static byte[] ciphertext = {-36,-5,9,10,67,6,-4,-53,82,-91};

    static byte[] key = {70,-109,103,88,120,-37,-112,-63,108,47};

    static byte[] iv = {-113,42,93,102,73,16,-62,-75,-84,19};

    static byte[] ALONG = {67,95,98,-7,-62,106,100,68,-67,-10};

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
        System.out.println(Arrays.asList(new MyJVMTest_104().parse(s)));
    }
}
