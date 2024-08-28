import java.security.MessageDigest;
import java.util.Arrays;

public class MyJVMTest_5859 {

    static MessageDigest messageDigest = null;

    static byte[] input = { -15, 86, 58, 34, -20, -52, -37, -121, 84, -105 };

    static boolean useClone = false;

    byte[] getHash(final MessageDigest messageDigest, final byte[] input, final boolean useClone) {
        for (int i = 0; i < 100; i++) messageDigest.update(input);
        return messageDigest.digest();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_5859().getHash(messageDigest, input, useClone)));
    }
}
