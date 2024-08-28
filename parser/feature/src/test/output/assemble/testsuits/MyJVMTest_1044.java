import java.security.*;
import java.security.spec.*;
import javax.crypto.*;

public class MyJVMTest_1044 {

    static Key key = null;

    static AlgorithmParameterSpec spec = null;

    static Mac internalMac = null;

    Key engineInit(Key key, AlgorithmParameterSpec spec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKey sKey;
        if (key instanceof SecretKey) {
            sKey = (SecretKey) key;
        } else {
            throw new IllegalArgumentException("Key must be a SecretKey");
        }
        byte[] sKeyEnc = sKey.getEncoded();
        int keyBits = sKeyEnc.length * 8;
        if (keyBits < 160) {
            throw new IllegalArgumentException("Key must be at least 160 bits");
        }
        internalMac.init(key, spec);
        return key;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1044().engineInit(key, spec);
    }
}
