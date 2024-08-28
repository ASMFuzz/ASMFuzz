import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_3145 {

    static String mode = "w(9=Xs[j=#";

    static String ALGO = "AES";

    static String PADDING = "NoPadding";

    static int KEYSIZE = 16;

    KeyGenerator execute(String mode) throws Exception {
        String transformation = ALGO + "/" + mode + "/" + PADDING;
        Cipher ci = Cipher.getInstance(transformation, "SunJCE");
        KeyGenerator kg = KeyGenerator.getInstance(ALGO, "SunJCE");
        kg.init(KEYSIZE * 8);
        SecretKey key = kg.generateKey();
        try {
            AlgorithmParameterSpec aps = null;
            ci.init(Cipher.ENCRYPT_MODE, key, aps);
        } catch (NullPointerException ex) {
            throw new Exception("null parameter is not handled correctly!");
        }
        System.out.println(transformation + ": Passed");
        return kg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3145().execute(mode);
    }
}
