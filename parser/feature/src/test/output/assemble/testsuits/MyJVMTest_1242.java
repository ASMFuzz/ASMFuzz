import java.util.*;
import java.nio.*;
import java.io.*;
import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_1242 {

    static String rParam1 = "?!~`U%E1<4";

    static StringReader r = new StringReader(rParam1);

    static String cipherAlg = "PBEWithMD5AndDES";

    static AlgorithmParameters GOOD_PARAMS = null;

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
        System.out.println(new MyJVMTest_1242().nextNibble(r));
    }
}
