import java.security.*;
import java.security.spec.*;
import javax.crypto.*;

public class MyJVMTest_16873 {

    static KeySpec keySpec = null;

    SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
        System.out.println("Trying the broken provider");
        throw new InvalidKeySpecException("I'm broken!!!");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16873().engineGenerateSecret(keySpec));
    }
}
