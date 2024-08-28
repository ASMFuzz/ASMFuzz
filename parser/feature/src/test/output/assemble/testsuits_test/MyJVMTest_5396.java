import java.security.*;
import javax.crypto.*;
import java.util.*;

public class MyJVMTest_5396 {

    static String algo = "#VJ=j+#6r1";

    static int[] keySizes = { -173660748, 2, 4, 2099069187, 483132534, 9, 1, -50687060, 6, 6 };

    boolean execute(String algo, int[] keySizes) throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance(algo, "SunJCE");
        Key keyWithDefaultSize = kg.generateKey();
        byte[] encoding = keyWithDefaultSize.getEncoded();
        int defKeyLen = encoding.length;
        if (defKeyLen == 0) {
            throw new Exception("default key length is 0!");
        } else if (defKeyLen != keySizes[0]) {
            throw new Exception("default key length mismatch!");
        }
        if (keySizes.length > 1) {
            for (int i = 0; i < keySizes.length; i++) {
                kg.init(keySizes[i] * 8);
                Key key = kg.generateKey();
                if (key.getEncoded().length != keySizes[i]) {
                    throw new Exception("key is generated with the wrong length!");
                }
            }
            try {
                kg.init(keySizes[0] * 8 + 1);
            } catch (InvalidParameterException ex) {
            } catch (Exception ex) {
                throw new Exception("wrong exception is thrown for invalid key size!");
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5396().execute(algo, keySizes));
    }
}
