import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_8050 {

    static String s = "'cC+VxB%kC";

    static String alg = "eX)+m+;c, ";

    static byte[] plaintext = {-46,81,39,-50,73,-84,-106,59,84,-3};

    static byte[] ciphertext = {55,-33,59,-77,-66,118,21,-85,114,61};

    static byte[] key = {-15,56,-97,52,108,-5,-22,-117,11,93};

    static byte[] iv = {-39,-128,-72,-67,90,93,-119,-9,18,-80};

    static byte[] ALONG = {29,-127,42,115,-123,-65,-100,120,32,106};

    byte[] s(String s) {
        try {
            return s.getBytes("UTF8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_8050().s(s)));
    }
}
