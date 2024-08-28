import java.security.*;
import java.util.*;
import javax.crypto.*;

public class MyJVMTest_6748 {

    static String algorithm = "3Q?TLKE#=p";

    static int size = 0;

    SecretKey generateSecretKey(String algorithm, int size) throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance(algorithm);
        generator.init(size);
        return generator.generateKey();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6748().generateSecretKey(algorithm, size));
    }
}
