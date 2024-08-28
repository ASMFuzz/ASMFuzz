import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.spec.AlgorithmParameterSpec;

public class MyJVMTest_7796 {

    static String algo = "J\"G-@dJ2G ";

    static SecretKey skey = null;

    static AlgorithmParameterSpec params = null;

    Mac doTest(String algo, SecretKey skey, AlgorithmParameterSpec params) throws Exception {
        Mac mac = Mac.getInstance(algo, "SunJCE");
        Mac macClone = (Mac) mac.clone();
        System.out.println(macClone.getProvider().toString());
        System.out.println(macClone.getAlgorithm());
        boolean thrown = false;
        try {
            macClone.update((byte) 0x12);
        } catch (IllegalStateException ise) {
            thrown = true;
        }
        if (!thrown) {
            throw new Exception("Expected IllegalStateException not thrown");
        }
        mac = Mac.getInstance(algo, "SunJCE");
        mac.init(skey, params);
        macClone = (Mac) mac.clone();
        System.out.println(macClone.getProvider().toString());
        System.out.println(macClone.getAlgorithm());
        mac.update((byte) 0x12);
        macClone.update((byte) 0x12);
        byte[] macFinal = mac.doFinal();
        byte[] macCloneFinal = macClone.doFinal();
        if (!java.util.Arrays.equals(macFinal, macCloneFinal)) {
            throw new Exception("ERROR: MAC result of init clone is different");
        } else
            System.out.println("MAC check#1 passed");
        mac.update((byte) 0x12);
        macClone = (Mac) mac.clone();
        mac.update((byte) 0x34);
        macClone.update((byte) 0x34);
        macFinal = mac.doFinal();
        macCloneFinal = macClone.doFinal();
        if (!java.util.Arrays.equals(macFinal, macCloneFinal)) {
            throw new Exception("ERROR: MAC result of updated clone is different");
        } else
            System.out.println("MAC check#2 passed");
        return macClone;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7796().doTest(algo, skey, params);
    }
}
