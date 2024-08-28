import java.security.*;
import java.security.spec.*;
import javax.crypto.*;

public class MyJVMTest_8377 {

    static KeySpec keySpec = null;

    SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
        System.out.println("Trying the good provider");
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8377().engineGenerateSecret(keySpec));
    }
}
