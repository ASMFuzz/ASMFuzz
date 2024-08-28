import java.security.*;

public class MyJVMTest_9699 {

    static MessageDigest digest = null;

    void engineReset() {
        digest.reset();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9699().engineReset();
    }
}
