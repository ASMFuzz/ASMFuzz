import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_14692 {

    static String pParam1 = "8l{B+ MoP.";

    static double pParam2 = Double.NaN;

    static String pParam3 = "Ga4GK(X>;q";

    static Provider p = new AuthProvider(pParam1, pParam2, pParam3);

    String hexDump(byte[] b) {
        if (b == null) {
            return "(null)";
        }
        StringBuffer sb = new StringBuffer(b.length * 3);
        for (int i = 0; i < b.length; i++) {
            int k = b[i] & 0xff;
            if (i != 0) {
                sb.append(':');
            }
            sb.append(hexDigits[k >>> 4]);
            sb.append(hexDigits[k & 0xf]);
        }
        return sb.toString();
    }

    static char[] hexDigits = "0123456789abcdef".toCharArray();

    static String alg = ")80k;(|nA\"";

    static byte[] plaintext = {40,-34,-57,-116,-125,-12,43,-118,-67,-43};

    static byte[] ciphertext = {48,118,22,-77,-72,119,1,-115,94,-41};

    static char[] password = {'0',Character.MIN_VALUE,Character.MIN_VALUE,Character.MAX_VALUE,'0',Character.MAX_VALUE,Character.MAX_VALUE,Character.MIN_VALUE,'O',Character.MIN_VALUE};

    static byte[] salt = {-101,5,-110,-94,-88,-108,-120,-83,105,20};

    static int ic = 6;

    Cipher run(Provider p) throws Exception {
        Cipher cipher = Cipher.getInstance(alg, p);
        PBEKeySpec pbeKeySpec = new PBEKeySpec(password);
        SecretKeyFactory keyFac = SecretKeyFactory.getInstance("PBE", p);
        PBEParameterSpec pbeParamSpec = new PBEParameterSpec(salt, ic);
        SecretKey key = keyFac.generateSecret(pbeKeySpec);
        cipher.init(Cipher.ENCRYPT_MODE, key, pbeParamSpec);
        byte[] enc = cipher.doFinal(plaintext);
        if (Arrays.equals(ciphertext, enc) == false) {
            System.out.println("Cipher test encryption for " + alg + " failed:");
            System.out.println("plaintext:  " + hexDump(plaintext));
            System.out.println("ciphertext: " + hexDump(ciphertext));
            System.out.println("encrypted:  " + hexDump(enc));
            System.out.println("password:   " + password);
            System.out.println("salt:       " + hexDump(salt));
            System.out.println("iterationCount: " + ic);
            throw new Exception("encryption test for " + alg + " failed");
        }
        enc = cipher.doFinal(plaintext);
        if (Arrays.equals(ciphertext, enc) == false) {
            throw new Exception("Re-encryption test failed");
        }
        cipher.init(Cipher.DECRYPT_MODE, key, pbeParamSpec);
        byte[] dec = cipher.doFinal(ciphertext);
        if (Arrays.equals(plaintext, dec) == false) {
            System.out.println("plaintext:  " + hexDump(plaintext));
            System.out.println("ciphertext: " + hexDump(ciphertext));
            System.out.println("decrypted:  " + hexDump(dec));
            System.out.println("password:   " + password);
            System.out.println("salt:       " + hexDump(salt));
            System.out.println("iterationCount: " + ic);
            throw new Exception("decryption test for " + alg + " failed");
        }
        System.out.println("passed: " + alg);
        return cipher;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14692().run(p);
    }
}
