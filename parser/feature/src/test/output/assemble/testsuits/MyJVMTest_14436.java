import java.security.*;

public class MyJVMTest_14436 {

    static byte[] input = { -7, -78, -42, -120, -68, 53, 25, 86, 60, 119 };

    static int offset = 1727589649;

    static int len = 3;

    static MessageDigest digest = null;

    int engineUpdate(byte[] input, int offset, int len) {
        digest.update(input, offset, len);
        return len;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14436().engineUpdate(input, offset, len);
    }
}
