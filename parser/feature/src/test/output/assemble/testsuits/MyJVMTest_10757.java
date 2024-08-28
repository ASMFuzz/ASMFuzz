import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_10757 {

    static String ALGO = "AES";

    static int KEYSIZE = 16;

    boolean execute() throws Exception {
        Cipher ci = Cipher.getInstance(ALGO, "SunJCE");
        KeyGenerator kg = KeyGenerator.getInstance(ALGO, "SunJCE");
        kg.init(KEYSIZE * 8);
        SecretKey key = kg.generateKey();
        try {
            ci.init(Cipher.ENCRYPT_MODE, key);
        } catch (InvalidKeyException ex) {
            throw new Exception("key length is mis-intepreted!");
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10757().execute());
    }
}
