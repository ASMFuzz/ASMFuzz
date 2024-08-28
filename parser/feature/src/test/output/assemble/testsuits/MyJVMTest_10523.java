import java.security.*;
import java.security.spec.*;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_10523 {

    static String mode = "x%ICLFn8 ,";

    static String padding = "T?2o$G/tL~";

    static String ALGO = "AES";

    static int KEYSIZE = 16;

    static byte[] plainText = new byte[125];

    Cipher execute(String mode, String padding) throws Exception {
        String transformation = ALGO + "/" + mode + "/" + padding;
        Cipher ci = Cipher.getInstance(transformation, "SunJCE");
        KeyGenerator kg = KeyGenerator.getInstance(ALGO, "SunJCE");
        kg.init(KEYSIZE * 8);
        SecretKey key = kg.generateKey();
        ci.init(Cipher.ENCRYPT_MODE, key);
        byte[] cipherText = ci.doFinal(plainText);
        if (mode.equalsIgnoreCase("GCM")) {
            AlgorithmParameters params = ci.getParameters();
            ci.init(Cipher.DECRYPT_MODE, key, params);
        } else {
            byte[] iv = ci.getIV();
            AlgorithmParameterSpec aps = new IvParameterSpec(iv);
            ci.init(Cipher.DECRYPT_MODE, key, aps);
        }
        byte[] recoveredText = new byte[plainText.length];
        try {
            int len = ci.doFinal(cipherText, 0, cipherText.length, recoveredText);
        } catch (ShortBufferException ex) {
            throw new Exception("output buffer is the right size!");
        }
        if (!Arrays.equals(plainText, recoveredText)) {
            throw new Exception("encryption/decryption does not work!");
        }
        if (Arrays.equals(plainText, cipherText)) {
            throw new Exception("encryption does not work!");
        }
        if (padding.equalsIgnoreCase("PKCS5Padding")) {
            if ((cipherText.length / 16) * 16 != cipherText.length) {
                throw new Exception("padding does not work!");
            }
        }
        System.out.println(transformation + ": Passed");
        return ci;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10523().execute(mode, padding);
    }
}
