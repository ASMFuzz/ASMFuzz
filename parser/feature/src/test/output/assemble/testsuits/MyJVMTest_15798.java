import java.io.*;
import java.security.*;

public class MyJVMTest_15798 {

    String supportedNativeAlgo() {
        String nativeSr = "Windows-PRNG";
        try {
            SecureRandom.getInstance(nativeSr);
        } catch (NoSuchAlgorithmException e) {
            nativeSr = "NativePRNG";
        }
        return nativeSr;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15798().supportedNativeAlgo());
    }
}
