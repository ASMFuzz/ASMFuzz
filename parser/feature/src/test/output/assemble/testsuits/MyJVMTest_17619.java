import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_17619 {

    static String s = "r?i9`IH4R{";

    static String alg = "\"gD8NfOmP:";

    static byte[] plaintext = {92,11,106,96,34,36,0,-68,40,20};

    static byte[] ciphertext = {56,60,-83,-12,-26,7,-47,-84,-97,35};

    static byte[] key = {-34,-75,41,88,-7,31,-62,87,116,69};

    static byte[] iv = {-111,47,-102,-18,-7,-23,38,41,16,-49};

    static byte[] ALONG = {62,-11,-100,98,-114,121,26,-24,20,12};

    byte[] s(String s) {
        try {
            return s.getBytes("UTF8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_17619().s(s)));
    }
}
