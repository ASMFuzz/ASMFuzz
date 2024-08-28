import java.io.*;
import java.util.*;
import java.security.*;
import java.security.interfaces.*;

public class MyJVMTest_16236 {

    static String algorithm = "$8o]\\oELg}";

    static PrivateKey privateKey = null;

    static PublicKey publicKey = null;

    static Provider provider = null;

    static byte[] data = {127,107,-108,-127,108,76,67,-99,-21,42};

    Signature testSignature(String algorithm, PrivateKey privateKey, PublicKey publicKey) throws Exception {
        System.out.println("Testing " + algorithm + "...");
        Signature s = Signature.getInstance(algorithm, provider);
        s.initSign(privateKey);
        s.update(data);
        byte[] sig = s.sign();
        s.initVerify(publicKey);
        s.update(data);
        boolean result;
        result = s.verify(sig);
        if (result == false) {
            throw new Exception("Verification 1 failed");
        }
        s.update(data);
        result = s.verify(sig);
        if (result == false) {
            throw new Exception("Verification 2 failed");
        }
        result = s.verify(sig);
        if (result == true) {
            throw new Exception("Verification 3 succeeded");
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16236().testSignature(algorithm, privateKey, publicKey);
    }
}
