import java.security.*;
import java.security.interfaces.*;
import java.security.spec.*;
import java.math.BigInteger;

public class MyJVMTest_3854 {

    static KeyPairGenerator kpg = null;

    static int exponentParam1 = 607;

    static byte[] exponentParam2 = { 106, -38, 69, -113, -69, -3, 47, -32, -125, 14 };

    static BigInteger exponent = new BigInteger(exponentParam1, exponentParam2);

    static int keyLen = 512;

    static BigInteger[] validExponents = new BigInteger[] { RSAKeyGenParameterSpec.F0, RSAKeyGenParameterSpec.F4, BigInteger.ONE.shiftLeft(keyLen - 1).subtract(BigInteger.ONE) };

    BigInteger testInvalidExponents(KeyPairGenerator kpg, BigInteger exponent) {
        System.out.println("Testing exponent = " + exponent.toString(16));
        try {
            kpg.initialize(new RSAKeyGenParameterSpec(keyLen, exponent));
            kpg.generateKeyPair();
            throw new RuntimeException("Error: Expected IAPE not thrown.");
        } catch (InvalidAlgorithmParameterException iape) {
            System.out.println("OK, expected IAPE thrown");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error: unexpected exception " + e);
        }
        return exponent;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3854().testInvalidExponents(kpg, exponent);
    }
}
