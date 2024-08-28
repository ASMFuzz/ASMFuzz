import java.security.*;
import java.security.spec.*;

public class MyJVMTest_6424 {

    static String keyalg = "'g>k/IM;c7";

    static int size = 5;

    KeyPair generateKeys(String keyalg, int size) throws NoSuchAlgorithmException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance(keyalg);
        kpg.initialize(size);
        return kpg.generateKeyPair();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6424().generateKeys(keyalg, size));
    }
}
