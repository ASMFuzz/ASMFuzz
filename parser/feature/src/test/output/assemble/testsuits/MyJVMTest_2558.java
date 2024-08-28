import java.security.*;
import java.security.interfaces.*;

public class MyJVMTest_2558 {

    static PublicKey kpParam1 = null;

    static PrivateKey kpParam2 = null;

    static KeyPair kp = new KeyPair(kpParam1, kpParam2);

    static int len = 6;

    int checkKeyLength(KeyPair kp, int len) throws Exception {
        DSAPublicKey key = (DSAPublicKey) kp.getPublic();
        int n = key.getParams().getP().bitLength();
        System.out.println("Key length: " + n);
        if (len != n) {
            throw new Exception("Wrong key length");
        }
        return n;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2558().checkKeyLength(kp, len);
    }
}
