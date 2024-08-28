import java.security.*;
import java.util.*;

public class MyJVMTest_12080 {

    static String property = "#2\\l[1\\^A{";

    static boolean expected = true;

    void testStrongInstance(boolean expected) throws Exception {
        boolean result;
        try {
            SecureRandom.getInstanceStrong();
            result = true;
        } catch (NoSuchAlgorithmException e) {
            result = false;
        }
        if (expected != result) {
            throw new Exception("Received: " + result);
        }
    }

    String testProperty(String property, boolean expected) throws Exception {
        System.out.println("Testing: '" + property + "' " + expected);
        final String origStrongAlgoProp = Security.getProperty("securerandom.strongAlgorithms");
        try {
            Security.setProperty("securerandom.strongAlgorithms", property);
            testStrongInstance(expected);
        } finally {
            Security.setProperty("securerandom.strongAlgorithms", origStrongAlgoProp);
        }
        return property;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12080().testProperty(property, expected);
    }
}
