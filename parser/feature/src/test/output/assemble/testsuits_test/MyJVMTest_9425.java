import java.io.*;
import java.security.*;
import java.security.cert.*;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_9425 {

    static String algorithm = "5M' :BpR7I";

    static int size = 4;

    static int len = 1736884517;

    SecretKey generateSecretKey(String algorithm, int size) throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance(algorithm);
        generator.init(size);
        return generator.generateKey();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9425().generateSecretKey(algorithm, size));
    }
}
