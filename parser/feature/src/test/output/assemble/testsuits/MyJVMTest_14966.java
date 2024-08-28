import java.security.*;
import javax.crypto.*;
import java.util.*;

public class MyJVMTest_14966 {

    static String algo = "M%XR2-lU~Z";

    static int keysize = 0;

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
        new MyJVMTest_14966().runTest(algo, keysize);
    }
}
