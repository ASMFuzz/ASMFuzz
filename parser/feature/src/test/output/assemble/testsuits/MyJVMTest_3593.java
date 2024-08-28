import java.security.*;
import java.security.spec.*;
import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_3593 {

    static String crypt = "XDxhA;DXyl";

    static String mode = "\"<W#s',sZg";

    static String padding = "|y5wE@Q6Jy";

    static Cipher cipher = null;

    static IvParameterSpec params = null;

    static SecretKey cipherKey = null;

    static byte[] key = { (byte) 0x01, (byte) 0x23, (byte) 0x45, (byte) 0x67, (byte) 0x89, (byte) 0xab, (byte) 0xcd, (byte) 0xef };

    static byte[] key3 = { (byte) 0x01, (byte) 0x23, (byte) 0x45, (byte) 0x67, (byte) 0x89, (byte) 0xab, (byte) 0xcd, (byte) 0xef, (byte) 0xf0, (byte) 0xe1, (byte) 0xd2, (byte) 0xc3, (byte) 0xb4, (byte) 0xa5, (byte) 0x96, (byte) 0x87, (byte) 0xfe, (byte) 0xdc, (byte) 0xba, (byte) 0x98, (byte) 0x76, (byte) 0x54, (byte) 0x32, (byte) 0x10 };

    static byte[] iv = { (byte) 0xfe, (byte) 0xdc, (byte) 0xba, (byte) 0x98, (byte) 0x76, (byte) 0x54, (byte) 0x32, (byte) 0x10 };

    StringBuffer init(String crypt, String mode, String padding) throws Exception {
        KeySpec desKeySpec = null;
        SecretKeyFactory factory = null;
        StringBuffer cipherName = new StringBuffer(crypt);
        if (mode.length() != 0)
            cipherName.append("/" + mode);
        if (padding.length() != 0)
            cipherName.append("/" + padding);
        cipher = Cipher.getInstance(cipherName.toString(), "SunJCE");
        if (crypt.endsWith("ede")) {
            desKeySpec = new DESedeKeySpec(key3);
            factory = SecretKeyFactory.getInstance("DESede", "SunJCE");
        } else {
            desKeySpec = new DESKeySpec(key);
            factory = SecretKeyFactory.getInstance("DES", "SunJCE");
        }
        cipherKey = factory.generateSecret(desKeySpec);
        if (!mode.equals("ECB"))
            params = new IvParameterSpec(iv);
        else
            params = null;
        return cipherName;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3593().init(crypt, mode, padding);
    }
}
