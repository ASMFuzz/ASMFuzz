import java.security.*;

public class MyJVMTest_5090 {

    static byte[] rs = { 76, 4, 50, 38, 88, 123, 12, 44, 21, 94 };

    static int count = 0;

    byte[] nextBytes(byte[] rs) {
        count++;
        return rs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5090().nextBytes(rs);
    }
}
