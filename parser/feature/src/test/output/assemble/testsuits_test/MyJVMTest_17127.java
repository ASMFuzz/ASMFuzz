import java.util.*;
import java.security.*;
import javax.crypto.*;

public class MyJVMTest_17127 {

    static String hashAlg = "-m $*2Kp`*";

    static int dataLength = 9;

    static Provider cp = null;

    static PrivateKey privateKey = null;

    static PublicKey publicKey = null;

    Cipher testEncryptDecrypt(String hashAlg, int dataLength) throws Exception {
        System.out.println("Testing OAEP with hash " + hashAlg + ", " + dataLength + " bytes");
        Cipher c = Cipher.getInstance("RSA/ECB/OAEPwith" + hashAlg + "andMGF1Padding", cp);
        c.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] data = new byte[dataLength];
        byte[] enc = c.doFinal(data);
        c.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] dec = c.doFinal(enc);
        if (Arrays.equals(data, dec) == false) {
            throw new Exception("Data does not match");
        }
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17127().testEncryptDecrypt(hashAlg, dataLength);
    }
}
