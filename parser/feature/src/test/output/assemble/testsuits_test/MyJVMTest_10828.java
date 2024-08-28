import java.security.*;
import java.security.spec.*;
import javax.crypto.*;

public class MyJVMTest_10828 {

    static int mode = 0;

    static String ALGO = "DES";

    static Cipher c = null;

    static SecretKey key = null;

    int checkMode(int mode) throws Exception {
        c.init(mode, key);
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
        return mode;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10828().checkMode(mode);
    }
}
