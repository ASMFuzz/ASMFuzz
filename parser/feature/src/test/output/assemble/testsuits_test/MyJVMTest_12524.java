import java.io.*;
import java.security.*;

public class MyJVMTest_12524 {

    static String s1 = "=>LQ7\"n0l\\";

    static byte[] srParam1 = { -33, -18, 14, 116, -67, -13, 105, 124, -14, -34 };

    static SecureRandom sr = new SecureRandom(srParam1);

    String check(String s1, SecureRandom sr) throws Exception {
        String s2 = sr.getAlgorithm();
        if (s1.equals(s2) == false) {
            throw new Exception("Expected " + s1 + ", got " + s2);
        }
        return s2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12524().check(s1, sr);
    }
}
