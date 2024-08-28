import java.io.*;
import java.security.*;
import java.security.KeyStore.*;
import java.security.cert.*;
import javax.crypto.*;
import javax.security.auth.callback.*;

public class MyJVMTest_10264 {

    static String algorithm = ")7WtwCw/a>";

    static int size = 813725583;

    static ProtectionParameter protection = null;

    SecretKey generateSecretKey(String algorithm, int size) throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance(algorithm);
        generator.init(size);
        return generator.generateKey();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10264().generateSecretKey(algorithm, size));
    }
}
