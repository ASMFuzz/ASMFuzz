import java.util.*;
import java.nio.*;
import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_17693 {

    static boolean isUnlimited = false;

    String runTest1(boolean isUnlimited) throws Exception {
        System.out.println("Testing " + (isUnlimited ? "un" : "") + "limited policy...");
        String algo = "Blowfish";
        int keyLength = Cipher.getMaxAllowedKeyLength(algo);
        AlgorithmParameterSpec spec = Cipher.getMaxAllowedParameterSpec(algo);
        if (isUnlimited) {
            if ((keyLength != Integer.MAX_VALUE) || (spec != null)) {
                throw new Exception("Check for " + algo + " failed under unlimited policy");
            }
        } else {
            if ((keyLength != 128) || (spec != null)) {
                throw new Exception("Check for " + algo + " failed under default policy");
            }
        }
        algo = "RC5";
        keyLength = Cipher.getMaxAllowedKeyLength(algo);
        RC5ParameterSpec rc5param = (RC5ParameterSpec) Cipher.getMaxAllowedParameterSpec(algo);
        if (isUnlimited) {
            if ((keyLength != Integer.MAX_VALUE) || (rc5param != null)) {
                throw new Exception("Check for " + algo + " failed under unlimited policy");
            }
        } else {
            if ((keyLength != 128) || (rc5param.getRounds() != 12) || (rc5param.getVersion() != Integer.MAX_VALUE) || (rc5param.getWordSize() != Integer.MAX_VALUE)) {
                throw new Exception("Check for " + algo + " failed under default policy");
            }
        }
        System.out.println("All tests passed");
        return algo;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17693().runTest1(isUnlimited);
    }
}
