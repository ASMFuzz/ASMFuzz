import java.security.*;
import java.util.*;

public class MyJVMTest_12142 {

    static boolean expected = false;

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
        new MyJVMTest_12142().testStrongInstance(expected);
    }
}
