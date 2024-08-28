import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import javax.crypto.interfaces.*;
import java.util.*;

public class MyJVMTest_8234 {

    static int iterCount = 0;

    static String password = "Di(@o_+0dM";

    static byte[] salt = { 106, -54, -91, -1, 88, -34, -96, 66, -36, -62 };

    static String expectedVal = "&{'Gl1nK8=";

    static PBEKeySpec[] keySpecs = {null,null,null,null,null,null,null,null,null,null};

    static String[] expectedVals = {"rTB9IHyXXH","QBzg\\k$WiA","0L]mVys{QE","8/|z7 9j5I","?Z2ubXn3O}","zrZ)]4l. N","6)H&(i)8TL","k!W\"fb,w]T","7q$bq3Gs>g","\\$;`b|(H>4"};

    String init(int iterCount, String password, byte[] salt, String expectedVal) {
        try {
            int numOfKeySizes = PBKDF2HmacSHA1FactoryTest.KEY_SIZES.length;
            keySpecs = new PBEKeySpec[numOfKeySizes];
            expectedVals = new String[numOfKeySizes];
            for (int i = 0; i < numOfKeySizes; i++) {
                int keySize = PBKDF2HmacSHA1FactoryTest.KEY_SIZES[i];
                keySpecs[i] = new PBEKeySpec(password.toCharArray(), salt, iterCount, keySize);
                expectedVals[i] = expectedVal.substring(0, keySize / 4);
            }
        } catch (Exception ex) {
            keySpecs = null;
            expectedVals = null;
        }
        return expectedVal;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8234().init(iterCount, password, salt, expectedVal);
    }
}
