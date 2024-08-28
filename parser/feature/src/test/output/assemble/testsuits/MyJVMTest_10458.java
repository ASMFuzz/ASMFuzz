import java.security.*;
import java.util.*;

public class MyJVMTest_10458 {

    static String signAlgorithm = "W?WW&^hxWG";

    static PublicKey publicKey = null;

    static byte[] signature = { 81, -17, -28, 96, 11, -32, -15, -78, 100, 61 };

    static byte[] toBeSigned = new byte[] { 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x10 };

    Signature verifyUsing(String signAlgorithm, PublicKey publicKey, byte[] signature) throws Exception {
        Signature sig1 = Signature.getInstance(signAlgorithm, "SunMSCAPI");
        if (sig1 == null) {
            throw new Exception("'" + signAlgorithm + "' is not supported");
        }
        System.out.println("Using " + signAlgorithm + " verifier from the " + sig1.getProvider().getName() + " JCE provider");
        System.out.println("Using key: " + publicKey);
        System.out.println("\nVerifying RSA Signature over a " + toBeSigned.length + "-byte data (signature length: " + signature.length * 8 + " bits)");
        System.out.println(String.format("0x%0" + (signature.length * 2) + "x", new java.math.BigInteger(1, signature)));
        sig1.initVerify(publicKey);
        sig1.update(toBeSigned);
        if (sig1.verify(signature)) {
            System.out.println("Verify PASSED\n");
        } else {
            throw new Exception("Verify FAILED");
        }
        return sig1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10458().verifyUsing(signAlgorithm, publicKey, signature);
    }
}
