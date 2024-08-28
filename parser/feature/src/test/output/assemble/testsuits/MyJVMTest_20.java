import java.security.*;

public class MyJVMTest_20 {

    static byte input = 0;

    static MessageDigest digest = null;

    byte engineUpdate(byte input) {
        digest.update(input);
        return input;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_20().engineUpdate(input);
    }
}
