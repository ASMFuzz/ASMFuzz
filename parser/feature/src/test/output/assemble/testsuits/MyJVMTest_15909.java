import java.security.*;
import java.security.spec.*;

public class MyJVMTest_15909 {

    static String keyalg = "!`X{lo'0=u";

    static int size = 4;

    KeyPair generateKeys(String keyalg, int size) throws NoSuchAlgorithmException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance(keyalg);
        kpg.initialize(size);
        return kpg.generateKeyPair();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15909().generateKeys(keyalg, size));
    }
}
