import java.security.*;

public class MyJVMTest_535 {

    static MessageDigest digest = null;

    void engineReset() {
        digest.reset();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_535().engineReset();
    }
}
