import java.security.*;

public class MyJVMTest_14503 {

    static byte[] rs = { -113, -128, -62, -5, -76, -107, -32, -122, 48, 62 };

    static int count = 0;

    byte[] nextBytes(byte[] rs) {
        count++;
        return rs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14503().nextBytes(rs);
    }
}
