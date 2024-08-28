import java.util.*;
import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_13866 {

    static String algo = "M[;^-mIA&<";

    static int length = 0;

    static String KEY_ALGO = "PBE";

    static String PROVIDER = "SunJCE";

    static SecretKey key = null;

    Mac runtest(String algo, int length) throws Exception {
        System.out.println("Testing: " + algo);
        if (key == null) {
            char[] password = { 't', 'e', 's', 't' };
            PBEKeySpec keySpec = new PBEKeySpec(password);
            SecretKeyFactory kf = SecretKeyFactory.getInstance(KEY_ALGO, PROVIDER);
            key = kf.generateSecret(keySpec);
        }
        Mac mac = Mac.getInstance(algo, PROVIDER);
        byte[] plainText = new byte[30];
        PBEParameterSpec spec = new PBEParameterSpec("saltValue".getBytes(), 250);
        mac.init(key, spec);
        mac.update(plainText);
        byte[] value1 = mac.doFinal();
        if (value1.length != length) {
            throw new Exception("incorrect MAC output length, expected " + length + ", got " + value1.length);
        }
        mac.update(plainText);
        byte[] value2 = mac.doFinal();
        if (!Arrays.equals(value1, value2)) {
            throw new Exception("generated different MAC outputs");
        }
        return mac;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13866().runtest(algo, length);
    }
}
