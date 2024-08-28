import java.security.*;
import java.util.*;
import javax.crypto.*;

public class MyJVMTest_8507 {

    static String algorithm = "N\"+\\r:_!vB";

    static int size = -412749561;

    KeyPair generateKeyPair(String algorithm, int size) throws NoSuchAlgorithmException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance(algorithm);
        generator.initialize(size);
        return generator.genKeyPair();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8507().generateKeyPair(algorithm, size));
    }
}
