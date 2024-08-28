import java.security.*;
import java.util.*;

public class MyJVMTest_12404 {

    static String os = System.getProperty("os.name", "unknown");

    void testNativePRNGImpls() throws Exception {
        SecureRandom sr;
        byte[] ba;
        System.out.println("Testing new NativePRNGImpls");
        if (os.startsWith("Windows")) {
            System.out.println("Skip windows testing.");
            return;
        }
        System.out.println("Testing regular");
        sr = SecureRandom.getInstance("NativePRNG");
        if (!sr.getAlgorithm().equals("NativePRNG")) {
            throw new Exception("sr.getAlgorithm(): " + sr.getAlgorithm());
        }
        ba = sr.generateSeed(1);
        sr.nextBytes(ba);
        sr.setSeed(ba);
        System.out.println("Testing NonBlocking");
        sr = SecureRandom.getInstance("NativePRNGNonBlocking");
        if (!sr.getAlgorithm().equals("NativePRNGNonBlocking")) {
            throw new Exception("sr.getAlgorithm(): " + sr.getAlgorithm());
        }
        ba = sr.generateSeed(1);
        sr.nextBytes(ba);
        sr.setSeed(ba);
        if (os.equals("Linux")) {
            System.out.println("Skip Linux blocking test.");
            return;
        }
        System.out.println("Testing Blocking");
        sr = SecureRandom.getInstance("NativePRNGBlocking");
        if (!sr.getAlgorithm().equals("NativePRNGBlocking")) {
            throw new Exception("sr.getAlgorithm(): " + sr.getAlgorithm());
        }
        ba = sr.generateSeed(1);
        sr.nextBytes(ba);
        sr.setSeed(ba);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12404().testNativePRNGImpls();
    }
}
