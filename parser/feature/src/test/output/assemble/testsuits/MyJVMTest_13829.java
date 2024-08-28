import java.security.*;
import java.security.spec.*;
import javax.crypto.*;

public class MyJVMTest_13829 {

    static SecretKey key = null;

    SecretKey engineTranslateKey(SecretKey key) throws InvalidKeyException {
        System.out.println("Trying the good provider");
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13829().engineTranslateKey(key));
    }
}
