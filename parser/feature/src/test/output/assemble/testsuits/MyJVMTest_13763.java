import java.security.*;
import java.security.spec.*;
import javax.crypto.*;

public class MyJVMTest_13763 {

    static SecretKey key = null;

    static Class keySpec = null;

    KeySpec engineGetKeySpec(SecretKey key, Class keySpec) throws InvalidKeySpecException {
        System.out.println("Trying the broken provider");
        throw new InvalidKeySpecException("I'm broken!!!");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13763().engineGetKeySpec(key, keySpec));
    }
}
