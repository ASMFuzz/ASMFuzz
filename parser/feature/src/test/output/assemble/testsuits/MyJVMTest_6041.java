import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_6041 {

    static String mode = "*qA~EG^-=h";

    static String ALGO = "AES";

    static String PADDING = "NoPadding";

    static int KEYSIZE = 16;

    KeyGenerator execute(String mode) throws Exception {
        AlgorithmParameterSpec aps = null;
        String transformation = ALGO + "/" + mode + "/" + PADDING;
        Cipher ci = Cipher.getInstance(transformation, "SunJCE");
        KeyGenerator kg = KeyGenerator.getInstance(ALGO, "SunJCE");
        kg.init(KEYSIZE * 8);
        SecretKey key = kg.generateKey();
        try {
            ci.init(Cipher.ENCRYPT_MODE, key, aps);
        } catch (InvalidAlgorithmParameterException ex) {
            throw new Exception("parameter should be generated when null is specified!");
        }
        System.out.println(transformation + ": Passed");
        return kg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6041().execute(mode);
    }
}
