import java.io.*;
import java.util.*;
import java.security.*;
import java.security.interfaces.*;
import java.security.spec.*;

public class MyJVMTest_17188 {

    static Key key1 = null;

    static Key key2 = null;

    Key testKey(Key key1, Key key2) throws Exception {
        if (key2.getAlgorithm().equals("RSA") == false) {
            throw new Exception("Algorithm not RSA");
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
        new MyJVMTest_17188().testKey(key1, key2);
    }
}
