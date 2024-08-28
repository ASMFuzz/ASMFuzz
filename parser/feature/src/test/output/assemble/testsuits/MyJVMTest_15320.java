import java.io.*;
import java.util.*;
import java.security.*;
import java.security.interfaces.*;
import java.security.spec.*;

public class MyJVMTest_15320 {

    static Key key1 = null;

    static Key key2 = null;

    static String ALGO = "RSASSA-PSS";

    Key testKey(Key key1, Key key2) throws Exception {
        if (key2.getAlgorithm().equals(ALGO) == false) {
            throw new Exception("Algorithm not " + ALGO);
        }
        if (key1 instanceof PublicKey) {
            if (key2.getFormat().equals("X.509") == false) {
                throw new Exception("Format not X.509");
            }
        } else if (key1 instanceof PrivateKey) {
            if (key2.getFormat().equals("PKCS#8") == false) {
                throw new Exception("Format not PKCS#8");
            }
        }
        if (key1.equals(key2) == false) {
            throw new Exception("Keys not equal");
        }
        if (Arrays.equals(key1.getEncoded(), key2.getEncoded()) == false) {
            throw new Exception("Encodings not equal");
        }
        return key2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15320().testKey(key1, key2);
    }
}
