import java.io.*;
import java.security.*;
import java.util.*;
import javax.crypto.*;

public class MyJVMTest_13645 {

    static CipherSpi encCipherParam1 = null;

    static String encCipherParam2Param1 = "$x0Gau,>o\\";

    static double encCipherParam2Param2 = Double.MAX_VALUE;

    static String encCipherParam2Param3 = "SYI`5@\\P{ ";

    static Provider encCipherParam2 = new AuthProvider(encCipherParam2Param1, encCipherParam2Param2, encCipherParam2Param3);

    static String encCipherParam3 = "s[g:,.U9sr";

    static Cipher encCipher = new Cipher(encCipherParam1, encCipherParam2, encCipherParam3);

    static CipherSpi decCipherParam1 = null;

    static String decCipherParam2Param1 = "G7W;vXPD4Z";

    static double decCipherParam2Param2 = Double.MIN_VALUE;

    static String decCipherParam2Param3 = "[d:s/41 0i";

    static Provider decCipherParam2 = new AuthProvider(decCipherParam2Param1, decCipherParam2Param2, decCipherParam2Param3);

    static String decCipherParam3 = "[[95,[XgCk";

    static Cipher decCipher = new Cipher(decCipherParam1, decCipherParam2, decCipherParam3);

    static byte[] plainText = { 6, 74, 21, 25, 41, -44, 41, 94, 43, -20 };

    byte[] test(Cipher encCipher, Cipher decCipher, byte[] plainText) throws Exception {
        ByteArrayInputStream baInput = new ByteArrayInputStream(plainText);
        CipherInputStream ciInput = new CipherInputStream(baInput, encCipher);
        ByteArrayOutputStream baOutput = new ByteArrayOutputStream();
        CipherOutputStream ciOutput = new CipherOutputStream(baOutput, decCipher);
        byte[] buffer = new byte[200];
        int len = ciInput.read(buffer);
        System.out.println("read " + len + " bytes from input buffer");
        while (len != -1) {
            ciOutput.write(buffer, 0, len);
            System.out.println("wite " + len + " bytes to output buffer");
            len = ciInput.read(buffer);
            if (len != -1) {
                System.out.println("read " + len + " bytes from input buffer");
            } else {
                System.out.println("finished reading");
            }
        }
        ciOutput.flush();
        ciInput.close();
        ciOutput.close();
        return baOutput.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_13645().test(encCipher, decCipher, plainText)));
    }
}
