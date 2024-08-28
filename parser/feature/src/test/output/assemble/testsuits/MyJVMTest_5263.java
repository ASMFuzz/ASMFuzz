import java.security.*;
import java.security.spec.*;
import javax.crypto.*;

public class MyJVMTest_5263 {

    static SecretKey key = null;

    SecretKey engineTranslateKey(SecretKey key) throws InvalidKeyException {
        System.out.println("Trying the broken provider");
        throw new InvalidKeyException("I'm broken!!!");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5263().engineTranslateKey(key));
    }
}
