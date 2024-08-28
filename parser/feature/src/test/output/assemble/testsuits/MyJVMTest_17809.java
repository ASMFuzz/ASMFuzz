import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import javax.crypto.interfaces.*;
import java.util.*;

public class MyJVMTest_17809 {

    static int iterCount = 5;

    static String password = " U7D'T!>GK";

    static byte[] salt = { -71, 102, -83, -9, -72, -119, -38, 126, -8, 53 };

    static String expectedVal = "6fc\"2x?+ov";

    static PBEKeySpec[] keySpecs = {null,null,null,null,null,null,null,null,null,null};

    static String[] expectedVals = {"2%(X/` Io}","$B|~Bv#hlF","9/1V}H<K!_","k3}k-NRftg","uJ=-]O0NL,","W~,,_Nv06/","BU/E[,F3<C","%j\"EB]l{Ye","v_<3|Y'Mm5","NwQZaN;0)@"};

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
        new MyJVMTest_17809().init(iterCount, password, salt, expectedVal);
    }
}
