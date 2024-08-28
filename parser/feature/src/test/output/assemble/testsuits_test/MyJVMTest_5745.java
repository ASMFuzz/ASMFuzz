import java.security.*;
import java.security.interfaces.*;
import java.security.spec.*;
import java.math.BigInteger;
import java.util.Random;

public class MyJVMTest_5745 {

    static KeyPairGenerator kpg = null;

    static int exponentParam1 = 740;

    static long exponentParam2Param1 = 0;

    static Random exponentParam2 = new Random(exponentParam2Param1);

    static BigInteger exponent = new BigInteger(exponentParam1, exponentParam2);

    static int keyLen = 512;

    BigInteger testValidExponents(KeyPairGenerator kpg, BigInteger exponent) {
        System.out.println("Testing exponent = " + exponent.toString(16));
        try {
            kpg.initialize(new RSAKeyGenParameterSpec(keyLen, exponent));
            kpg.generateKeyPair();
            System.out.println("OK, key pair generated");
        } catch (InvalidAlgorithmParameterException iape) {
            throw new RuntimeException("Error: Unexpected Exception: " + iape);
        }
        return exponent;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5745().testValidExponents(kpg, exponent);
    }
}
