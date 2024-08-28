import java.io.*;
import java.security.*;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_14341 {

    static String[] PBE_ALGORITHMS = new String[] { "default PBE algorithm", "PBEWithMD5AndDES", "PBEWithSHA1AndDESede", "PBEWithSHA1AndRC2_40", "PBEWithSHA1AndRC2_128", "PBEWithSHA1AndRC4_40", "PBEWithSHA1AndRC4_128", "PBEWithHmacSHA1AndAES_128", "PBEWithHmacSHA224AndAES_128", "PBEWithHmacSHA256AndAES_128", "PBEWithHmacSHA384AndAES_128", "PBEWithHmacSHA512AndAES_128", "PBEWithHmacSHA1AndAES_256", "PBEWithHmacSHA224AndAES_256", "PBEWithHmacSHA256AndAES_256", "PBEWithHmacSHA384AndAES_256", "PBEWithHmacSHA512AndAES_256" };

    static String KEYSTORE = "mykeystore.p12";

    static char[] KEYSTORE_PWD = "changeit".toCharArray();

    static char[] ENTRY_PWD = "protectit".toCharArray();

    static char[] USER_PWD = "hello1".toCharArray();

    int recover() throws Exception {
        int count = 0;
        KeyStore keystore = KeyStore.getInstance("PKCS12");
        System.out.println("\nLoading PKCS#12 keystore from: " + KEYSTORE);
        try (FileInputStream in = new FileInputStream(KEYSTORE)) {
            keystore.load(in, KEYSTORE_PWD);
        }
        SecretKey key;
        SecretKeyFactory factory;
        PBEKeySpec keySpec;
        for (String algorithm : PBE_ALGORITHMS) {
            key = (SecretKey) keystore.getKey("this entry is protected by " + algorithm, ENTRY_PWD);
            if (key != null) {
                count++;
                factory = SecretKeyFactory.getInstance(key.getAlgorithm());
                keySpec = (PBEKeySpec) factory.getKeySpec(key, PBEKeySpec.class);
                char[] pwd = keySpec.getPassword();
                System.out.println("Recovered user password '" + new String(pwd) + "' (protected by " + algorithm + ")");
                if (!Arrays.equals(USER_PWD, pwd)) {
                    throw new Exception("Failed to recover the user password " + "protected by " + algorithm);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14341().recover());
    }
}
