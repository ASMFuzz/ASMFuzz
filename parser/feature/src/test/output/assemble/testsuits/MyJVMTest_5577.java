import java.security.*;
import java.security.spec.*;
import javax.crypto.*;

public class MyJVMTest_5577 {

    static int mode = 4;

    static String opString = "N@Ic<ENxy{";

    static String ALGO = "DES";

    static Cipher c = null;

    static SecretKey key = null;

    String checkMode(int mode, String opString) throws Exception {
        c.init(mode, key);
        String output = c.toString();
        if (!output.contains("Cipher.DES/ECB/PKCS5Padding") && !output.contains(opString) && !output.contains("Algorithm from: SunJCE")) {
            throw new Exception("Unexpected toString() output:" + output);
        }
        switch(mode) {
            case Cipher.ENCRYPT_MODE:
            case Cipher.DECRYPT_MODE:
                try {
                    c.wrap(key);
                    throw new Exception("ERROR: should throw ISE for wrap()");
                } catch (IllegalStateException ise) {
                    System.out.println("expected ISE is thrown for wrap()");
                }
                try {
                    c.unwrap(new byte[16], ALGO, Cipher.SECRET_KEY);
                    throw new Exception("ERROR: should throw ISE for unwrap()");
                } catch (IllegalStateException ise) {
                    System.out.println("expected ISE is thrown for unwrap()");
                }
                break;
            case Cipher.WRAP_MODE:
            case Cipher.UNWRAP_MODE:
                try {
                    c.update(new byte[16]);
                    throw new Exception("ERROR: should throw ISE for update()");
                } catch (IllegalStateException ise) {
                    System.out.println("expected ISE is thrown for update()");
                }
                try {
                    c.doFinal();
                    throw new Exception("ERROR: should throw ISE for doFinal()");
                } catch (IllegalStateException ise) {
                    System.out.println("expected ISE is thrown for doFinal()");
                }
                break;
        }
        return output;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5577().checkMode(mode, opString);
    }
}
