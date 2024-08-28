import java.security.*;
import javax.crypto.*;
import java.util.*;

public class MyJVMTest_6571 {

    static String mode = "5%)*$dHRk}";

    static String padding = "rbGzYT9\"Jo";

    static String ALGO = "AES";

    static int KEYSIZE = 16;

    Cipher execute(String mode, String padding) throws Exception {
        String transformation = ALGO + "/" + mode + "/" + padding;
        Cipher ci = Cipher.getInstance(transformation, "SunJCE");
        KeyGenerator kg = KeyGenerator.getInstance(ALGO, "SunJCE");
        kg.init(KEYSIZE * 8);
        SecretKey key = kg.generateKey();
        AlgorithmParameters params = ci.getParameters();
        ci.init(Cipher.WRAP_MODE, key, params);
        byte[] wrappedKeyEncoding = ci.wrap(key);
        params = ci.getParameters();
        ci.init(Cipher.UNWRAP_MODE, key, params);
        Key recoveredKey = ci.unwrap(wrappedKeyEncoding, "AES", Cipher.SECRET_KEY);
        if (!key.equals(recoveredKey)) {
            throw new Exception("key after wrap/unwrap is different from the original!");
        }
        System.out.println(transformation + ": Passed");
        return ci;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6571().execute(mode, padding);
    }
}
