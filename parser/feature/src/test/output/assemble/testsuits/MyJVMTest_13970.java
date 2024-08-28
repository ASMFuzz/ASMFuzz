import java.security.*;
import java.util.*;

public class MyJVMTest_13970 {

    static String signAlgorithm = "UAZ<9;+O':";

    static PrivateKey privateKey = null;

    static byte[] toBeSigned = new byte[] { 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x10 };

    byte[] signUsing(String signAlgorithm, PrivateKey privateKey) throws Exception {
        Signature sig1 = Signature.getInstance(signAlgorithm, "SunMSCAPI");
        if (sig1 == null) {
            throw new Exception("'" + signAlgorithm + "' is not supported");
        }
        System.out.println("Using " + signAlgorithm + " signer from the " + sig1.getProvider().getName() + " JCE provider");
        System.out.println("Using key: " + privateKey);
        sig1.initSign(privateKey);
        sig1.update(toBeSigned);
        byte[] sigBytes = null;
        try {
            sigBytes = sig1.sign();
            System.out.println("Generated RSA signature over a " + toBeSigned.length + "-byte data (signature length: " + sigBytes.length * 8 + " bits)");
            System.out.println(String.format("0x%0" + (sigBytes.length * 2) + "x", new java.math.BigInteger(1, sigBytes)));
        } catch (SignatureException se) {
            System.out.println("Error generating RSA signature: " + se);
        }
        return sigBytes;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_13970().signUsing(signAlgorithm, privateKey)));
    }
}
