import java.security.*;
import java.util.*;

public class MyJVMTest_2846 {

    static boolean expected = true;

    boolean testStrongInstance(boolean expected) throws Exception {
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
        return result;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2846().testStrongInstance(expected);
    }
}
