import java.security.*;

public class MyJVMTest_9157 {

    static byte input = 127;

    static MessageDigest digest = null;

    byte engineUpdate(byte input) {
        digest.update(input);
        return input;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9157().engineUpdate(input);
    }
}
