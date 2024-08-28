import java.security.*;
import javax.crypto.*;
import javax.crypto.interfaces.*;
import javax.crypto.spec.*;
import java.math.BigInteger;

public class MyJVMTest_10205 {

    static PublicKey kpParam1 = null;

    static PrivateKey kpParam2 = null;

    static KeyPair kp = new KeyPair(kpParam1, kpParam2);

    static int pSize = 1;

    static int primeSize = 7;

    BigInteger checkKeyPair(KeyPair kp, int pSize) throws Exception {
        DHPrivateKey privateKey = (DHPrivateKey) kp.getPrivate();
        BigInteger p = privateKey.getParams().getP();
        if (p.bitLength() != pSize) {
            throw new Exception("Invalid modulus size: " + p.bitLength() + "/" + pSize);
        }
        if (!p.isProbablePrime(128)) {
            throw new Exception("Good luck, the modulus is composite!");
        }
        DHPublicKey publicKey = (DHPublicKey) kp.getPublic();
        p = publicKey.getParams().getP();
        if (p.bitLength() != pSize) {
            throw new Exception("Invalid modulus size: " + p.bitLength() + "/" + pSize);
        }
        BigInteger leftOpen = BigInteger.ONE;
        BigInteger rightOpen = p.subtract(BigInteger.ONE);
        BigInteger x = privateKey.getX();
        if ((x.compareTo(leftOpen) <= 0) || (x.compareTo(rightOpen) >= 0)) {
            throw new Exception("X outside range [2, p - 2]:  x: " + x + " p: " + p);
        }
        BigInteger y = publicKey.getY();
        if ((y.compareTo(leftOpen) <= 0) || (y.compareTo(rightOpen) >= 0)) {
            throw new Exception("Y outside range [2, p - 2]:  x: " + x + " p: " + p);
        }
        return p;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10205().checkKeyPair(kp, pSize);
    }
}
