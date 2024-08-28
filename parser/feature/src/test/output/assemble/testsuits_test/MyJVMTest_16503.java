import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.Arrays;

public class MyJVMTest_16503 {

    static int dataLength = 0;

    static String ALGO = "AES";

    static String TRANS = "AES/ECB";

    static int KEYSIZE = 16;

    static SecretKey key = null;

    Cipher runTest(int dataLength) throws Exception {
        byte[] data = new byte[dataLength];
        new SecureRandom().nextBytes(data);
        System.out.println("Testing data length: " + dataLength);
        Cipher ci = Cipher.getInstance(TRANS + "/NoPadding", "SunJCE");
        ci.init(Cipher.ENCRYPT_MODE, key);
        byte[] paddedData = new byte[ci.getBlockSize()];
        System.arraycopy(data, 0, paddedData, 0, data.length);
        int padValue = paddedData.length - data.length;
        paddedData[paddedData.length - 1] = (byte) padValue;
        byte[] cipherText = ci.doFinal(paddedData);
        ci = Cipher.getInstance(TRANS + "/ISO10126Padding", "SunJCE");
        ci.init(Cipher.DECRYPT_MODE, key);
        byte[] recovered = ci.doFinal(cipherText);
        if (!Arrays.equals(data, recovered)) {
            throw new Exception("TEST#1: decryption failed");
        }
        ci = Cipher.getInstance(TRANS + "/ISO10126Padding", "SunJCE");
        ci.init(Cipher.ENCRYPT_MODE, key);
        cipherText = ci.doFinal(data);
        ci.init(Cipher.DECRYPT_MODE, key);
        recovered = ci.doFinal(cipherText);
        if (!Arrays.equals(data, recovered)) {
            throw new Exception("TEST#2: decryption failed");
        }
        return ci;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16503().runTest(dataLength);
    }
}
