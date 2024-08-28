import java.security.*;
import java.security.spec.*;

public class MyJVMTest_4111 {

    static String digestAlgo = "B4q$B7&{v?";

    static int digestLen = 820281101;

    static int keySize = 170144361;

    PSSParameterSpec genPSSParameter(String digestAlgo, int digestLen, int keySize) {
        int saltLength = keySize / 8 - digestLen - 2;
        if (saltLength < 0) {
            System.out.println("keysize: " + keySize / 8 + ", digestLen: " + digestLen);
            return null;
        }
        return new PSSParameterSpec(digestAlgo, "MGF1", new MGF1ParameterSpec(digestAlgo), saltLength, 1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4111().genPSSParameter(digestAlgo, digestLen, keySize));
    }
}
