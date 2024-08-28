import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_5344 {

    static String rParam1 = "l3iCiEU<,o";

    static StringReader r = new StringReader(rParam1);

    static String alg = "c!&!b/y9, ";

    static byte[] plaintext = {-112,-26,-60,-35,107,-107,-69,-122,40,-28};

    static byte[] ciphertext = {61,-65,-65,123,66,-1,11,73,36,-13};

    static byte[] key = {-53,-78,-104,27,-12,92,-99,-35,76,2};

    static byte[] iv = {52,70,-18,-80,97,-54,127,98,44,-21};

    static byte[] ALONG = {82,-91,107,88,95,-124,-66,-31,-34,59};

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
        System.out.println(new MyJVMTest_5344().nextNibble(r));
    }
}
