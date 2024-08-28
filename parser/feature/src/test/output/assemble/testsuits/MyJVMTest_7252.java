import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_7252 {

    static int mode = 1;

    static byte[] BYTES_32 = new byte[32];

    String getModeStr(int mode) {
        return (mode == Cipher.ENCRYPT_MODE ? "ENC" : "WRAP");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7252().getModeStr(mode));
    }
}
