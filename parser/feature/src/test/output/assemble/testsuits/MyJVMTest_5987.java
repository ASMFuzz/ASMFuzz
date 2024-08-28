import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.math.*;
import java.util.*;

public class MyJVMTest_5987 {

    static CipherSpi cParam1 = null;

    static String cParam2Param1 = "^3)~[?gF|J";

    static double cParam2Param2 = 0d;

    static String cParam2Param3 = "0>wEH4,T#?";

    static Provider cParam2 = new AuthProvider(cParam2Param1, cParam2Param2, cParam2Param3);

    static String cParam3 = "i'tmEY<wis";

    static Cipher c = new Cipher(cParam1, cParam2, cParam3);

    static byte[] AAD = new byte[5];

    static byte[] PT = new byte[18];

    Cipher checkISE(Cipher c) throws Exception {
        try {
            c.updateAAD(AAD);
            throw new Exception("Should throw ISE for updateAAD()");
        } catch (IllegalStateException ise) {
        }
        try {
            c.update(PT);
            throw new Exception("Should throw ISE for update()");
        } catch (IllegalStateException ise) {
        }
        try {
            c.doFinal(PT);
            throw new Exception("Should throw ISE for doFinal()");
        } catch (IllegalStateException ise) {
        }
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5987().checkISE(c);
    }
}
