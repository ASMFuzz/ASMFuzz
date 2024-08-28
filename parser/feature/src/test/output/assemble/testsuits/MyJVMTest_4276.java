import java.io.*;
import java.security.*;
import java.util.*;
import javax.crypto.*;

public class MyJVMTest_4276 {

    static CipherSpi encCipherParam1 = null;

    static String encCipherParam2Param1 = "_Acm1PaX&@";

    static double encCipherParam2Param2 = Double.NEGATIVE_INFINITY;

    static String encCipherParam2Param3 = "\"WJ|G__}RL";

    static Provider encCipherParam2 = new AuthProvider(encCipherParam2Param1, encCipherParam2Param2, encCipherParam2Param3);

    static String encCipherParam3 = "B]\\8cu!9|p";

    static Cipher encCipher = new Cipher(encCipherParam1, encCipherParam2, encCipherParam3);

    static CipherSpi decCipherParam1 = null;

    static String decCipherParam2Param1 = "d,Sz-s#5Q/";

    static double decCipherParam2Param2 = Double.NEGATIVE_INFINITY;

    static String decCipherParam2Param3 = "p8],L.>L+@";

    static Provider decCipherParam2 = new AuthProvider(decCipherParam2Param1, decCipherParam2Param2, decCipherParam2Param3);

    static String decCipherParam3 = "n5Habx\"2S\"";

    static Cipher decCipher = new Cipher(decCipherParam1, decCipherParam2, decCipherParam3);

    static byte[] plainText = { 119, 89, -29, -62, -125, -89, 39, -84, 93, -38 };

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
        System.out.println(Arrays.asList(new MyJVMTest_4276().test(encCipher, decCipher, plainText)));
    }
}
