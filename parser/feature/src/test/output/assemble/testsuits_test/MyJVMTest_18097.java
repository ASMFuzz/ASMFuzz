import java.security.*;
import java.util.*;
import javax.crypto.*;

public class MyJVMTest_18097 {

    static String algorithm = "vJ\\Yf|O#a#";

    static int size = 0;

    KeyPair generateKeyPair(String algorithm, int size) throws NoSuchAlgorithmException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance(algorithm);
        generator.initialize(size);
        return generator.genKeyPair();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18097().generateKeyPair(algorithm, size));
    }
}
