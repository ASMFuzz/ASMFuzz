import java.security.*;

public class MyJVMTest_5026 {

    static byte[] input = { -116, -41, -5, -127, -39, 11, 19, 12, 11, 80 };

    static int offset = 0;

    static int len = 8;

    static MessageDigest digest = null;

    int engineUpdate(byte[] input, int offset, int len) {
        digest.update(input, offset, len);
        return len;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5026().engineUpdate(input, offset, len);
    }
}
