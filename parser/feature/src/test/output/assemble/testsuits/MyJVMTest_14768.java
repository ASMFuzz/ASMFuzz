import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_14768 {

    static String rParam1 = ":EqMmO@%Ak";

    static StringReader r = new StringReader(rParam1);

    static String alg = "`1x?b=`QBI";

    static byte[] plaintext = {-95,-31,94,-38,93,18,58,-6,82,44};

    static byte[] ciphertext = {-93,-50,14,126,96,-20,-80,67,56,91};

    static byte[] key = {61,-71,-109,-30,101,55,96,-95,81,-68};

    static byte[] iv = {-91,-115,24,-5,-101,88,17,18,-116,-58};

    static byte[] ALONG = {-106,0,-47,-44,62,52,19,122,-26,-8};

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
        System.out.println(new MyJVMTest_14768().nextNibble(r));
    }
}
