import java.io.*;
import java.util.*;
import java.security.*;
import java.security.interfaces.*;

public class MyJVMTest_6739 {

    static String algorithm = "-[GntpEgx'";

    static PrivateKey privateKey = null;

    static PublicKey publicKey = null;

    static Provider provider = null;

    static byte[] data = {-73,91,49,66,114,13,50,-11,-18,-107};

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
        new MyJVMTest_6739().testSignature(algorithm, privateKey, publicKey);
    }
}
