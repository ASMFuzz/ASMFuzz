import java.security.*;
import java.security.spec.*;

public class MyJVMTest_13472 {

    static String digestAlgo = ">!@^8na)gn";

    static int digestLen = 1;

    static int keySize = 4;

    PSSParameterSpec genPSSParameter(String digestAlgo, int digestLen, int keySize) {
        int saltLength = keySize / 8 - digestLen - 2;
        if (saltLength < 0) {
            System.out.println("keysize: " + keySize / 8 + ", digestLen: " + digestLen);
            return null;
        }
        return new PSSParameterSpec(digestAlgo, "MGF1", new MGF1ParameterSpec(digestAlgo), saltLength, 1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13472().genPSSParameter(digestAlgo, digestLen, keySize));
    }
}
