import java.security.*;
import java.util.*;

public class MyJVMTest_2787 {

    static String property = "scUtR&.8;E";

    static boolean expected = false;

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
        new MyJVMTest_2787().testProperty(property, expected);
    }
}
