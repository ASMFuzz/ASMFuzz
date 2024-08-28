import java.io.*;
import java.security.*;
import java.security.KeyStore.*;
import java.security.cert.*;
import javax.crypto.*;
import javax.security.auth.callback.*;

public class MyJVMTest_1071 {

    static String algorithm = ".wx9mBOmY4";

    static int size = 6;

    static ProtectionParameter protection = null;

    SecretKey generateSecretKey(String algorithm, int size) throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance(algorithm);
        generator.init(size);
        return generator.generateKey();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1071().generateSecretKey(algorithm, size));
    }
}
