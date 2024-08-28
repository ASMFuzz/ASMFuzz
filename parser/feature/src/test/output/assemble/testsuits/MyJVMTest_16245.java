import java.security.*;
import java.util.*;
import javax.crypto.*;

public class MyJVMTest_16245 {

    static String algorithm = "?vwm#>|p\"w";

    static int size = 2;

    SecretKey generateSecretKey(String algorithm, int size) throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance(algorithm);
        generator.init(size);
        return generator.generateKey();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16245().generateSecretKey(algorithm, size));
    }
}
