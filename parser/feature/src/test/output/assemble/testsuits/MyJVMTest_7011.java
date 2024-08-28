import java.security.*;
import java.util.*;

public class MyJVMTest_7011 {

    void handleLinuxRead(SecureRandom sr) throws Exception {
        if (os.equals("Linux")) {
            if (!sr.getAlgorithm().equalsIgnoreCase("NativePRNGBlocking")) {
                sr.nextBytes(new byte[34]);
            }
        } else {
            sr.nextBytes(new byte[34]);
            sr.generateSeed(34);
            sr.setSeed(new byte[34]);
        }
    }

    static String os = System.getProperty("os.name", "unknown");

    void testAllImpls() throws Exception {
        System.out.print("Testing:  AllImpls:  ");
        Iterator<String> i = Security.getAlgorithms("SecureRandom").iterator();
        while (i.hasNext()) {
            String s = i.next();
            System.out.print("/" + s);
            SecureRandom sr = SecureRandom.getInstance(s);
            handleLinuxRead(sr);
            handleLinuxRead(sr);
        }
        System.out.println("/");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7011().testAllImpls();
    }
}
