import java.security.*;
import java.security.spec.*;
import javax.crypto.*;

public class MyJVMTest_16223 {

    static SecretKey key = null;

    static Class keySpec = null;

    KeySpec engineGetKeySpec(SecretKey key, Class keySpec) throws InvalidKeySpecException {
        System.out.println("Trying the good provider");
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16223().engineGetKeySpec(key, keySpec));
    }
}
