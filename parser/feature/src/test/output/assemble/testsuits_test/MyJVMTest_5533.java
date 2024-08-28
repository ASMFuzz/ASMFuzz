import java.security.*;
import javax.crypto.*;
import java.util.*;

public class MyJVMTest_5533 {

    static String algo = "4O7ZA|-Sq5";

    static int keysize = 7;

    KeyGenerator runTest(String algo, int keysize) throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance(algo, "SunJCE");
        kg.init(keysize);
        Key generatedKey = kg.generateKey();
        int actualSizeInBits = generatedKey.getEncoded().length * 8;
        if (actualSizeInBits != keysize) {
            throw new Exception("generated key has wrong length: " + actualSizeInBits + " bits");
        }
        return kg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5533().runTest(algo, keysize);
    }
}
