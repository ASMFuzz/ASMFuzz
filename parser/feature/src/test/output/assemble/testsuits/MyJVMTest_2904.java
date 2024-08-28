import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.Arrays;

public class MyJVMTest_2904 {

    static int sizeInBytes = -1185628276;

    static byte[] BYTES_32 = new byte[32];

    SecretKey getKey(int sizeInBytes) {
        if (sizeInBytes <= BYTES_32.length) {
            return new SecretKeySpec(BYTES_32, 0, sizeInBytes, "AES");
        } else {
            return new SecretKeySpec(new byte[sizeInBytes], "AES");
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2904().getKey(sizeInBytes));
    }
}
