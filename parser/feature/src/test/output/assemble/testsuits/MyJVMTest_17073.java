import java.io.*;
import java.util.*;
import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_17073 {

    static CipherSpi cParam1 = null;

    static String cParam2Param1 = "#7Vge#AQxV";

    static double cParam2Param2 = Double.NaN;

    static String cParam2Param3 = "L!GTr&W<bw";

    static Provider cParam2 = new AuthProvider(cParam2Param1, cParam2Param2, cParam2Param3);

    static String cParam3 = "N(T?m3{<R8";

    static Cipher c = new Cipher(cParam1, cParam2, cParam3);

    static Key key = null;

    Key runTest(Cipher c, Key key) throws Exception {
        SecureRandom sr = new SecureRandom();
        for (int i = 0; i < 6; i++) {
            try {
                switch(i) {
                    case 0:
                        c.init(Cipher.ENCRYPT_MODE, key);
                        break;
                    case 1:
                        c.init(Cipher.ENCRYPT_MODE, key, sr);
                        break;
                    case 2:
                        c.init(Cipher.ENCRYPT_MODE, key, (AlgorithmParameters) null);
                        break;
                    case 3:
                        c.init(Cipher.ENCRYPT_MODE, key, (AlgorithmParameters) null, sr);
                        break;
                    case 4:
                        c.init(Cipher.ENCRYPT_MODE, key, (AlgorithmParameterSpec) null);
                        break;
                    case 5:
                        c.init(Cipher.ENCRYPT_MODE, key, (AlgorithmParameterSpec) null, sr);
                        break;
                }
                throw new Exception("...#" + i + " should throw IKE for " + key.getEncoded().length + "-byte keys");
            } catch (InvalidKeyException ike) {
                System.out.println("...#" + i + " expected IKE thrown");
            }
        }
        return key;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17073().runTest(c, key);
    }
}
