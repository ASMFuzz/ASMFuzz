import java.io.*;
import java.security.*;
import java.security.cert.*;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_273 {

    static String algorithm = "|lznGVQ\"k ";

    static int size = 863817179;

    static int len = 5;

    SecretKey generateSecretKey(String algorithm, int size) throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance(algorithm);
        generator.init(size);
        return generator.generateKey();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_273().generateSecretKey(algorithm, size));
    }
}
