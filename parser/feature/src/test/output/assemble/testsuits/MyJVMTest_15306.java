import java.security.MessageDigest;
import java.util.Arrays;

public class MyJVMTest_15306 {

    static MessageDigest messageDigest = null;

    static byte[] input = { -93, -68, 101, 62, -72, 120, -2, 82, -44, -20 };

    static boolean useClone = true;

    byte[] getHash(final MessageDigest messageDigest, final byte[] input, final boolean useClone) {
        for (int i = 0; i < 100; i++) messageDigest.update(input);
        return messageDigest.digest();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_15306().getHash(messageDigest, input, useClone)));
    }
}
