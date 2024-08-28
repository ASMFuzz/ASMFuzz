import java.io.*;
import java.security.*;
import javax.crypto.*;

public class MyJVMTest_5155 {

    static String algo = "z+1`JV}3)\\";

    static int keyLen = 0;

    String test(String algo, int keyLen) throws Exception {
        Provider p = Security.getProvider("SunJCE");
        System.out.println("=>Testing " + algo + " cipher with " + keyLen + "-bit key");
        KeyGenerator kg = KeyGenerator.getInstance(algo, p);
        kg.init(keyLen);
        SecretKey key = kg.generateKey();
        System.out.println("Generated key with algorithm " + key.getAlgorithm());
        Cipher cipher = Cipher.getInstance(algo, p);
        System.out.println("Requested cipher with algorithm " + algo);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        System.out.println("Initialization succeeded as expected");
        return algo;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5155().test(algo, keyLen);
    }
}
