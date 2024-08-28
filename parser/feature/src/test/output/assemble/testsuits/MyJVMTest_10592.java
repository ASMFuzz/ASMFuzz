import java.io.*;
import java.util.*;
import java.security.*;
import java.security.interfaces.*;
import java.security.spec.*;

public class MyJVMTest_10592 {

    static PublicKey kpParam1 = null;

    static PrivateKey kpParam2 = null;

    static KeyPair kp = new KeyPair(kpParam1, kpParam2);

    KeyPair checkKeyPair(KeyPair kp) throws Exception {
        PublicKey pubKey = kp.getPublic();
        if (!(pubKey instanceof RSAPublicKey)) {
            throw new Exception("Error: public key should be RSAPublicKey");
        }
        PrivateKey privKey = kp.getPrivate();
        if (!(privKey instanceof RSAPrivateKey)) {
            throw new Exception("Error: private key should be RSAPrivateKey");
        }
        return kp;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10592().checkKeyPair(kp);
    }
}
