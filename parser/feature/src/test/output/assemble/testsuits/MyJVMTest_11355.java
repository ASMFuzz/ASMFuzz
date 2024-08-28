import java.security.*;
import java.util.*;
import javax.crypto.*;

public class MyJVMTest_11355 {

    static byte[] bytes = { -47, -102, 103, -97, -5, -101, 64, -10, -5, -73 };

    boolean allZero(byte[] bytes) {
        int count = 0;
        for (byte b : bytes) {
            if (b == 0x00) {
                count++;
            }
        }
        return (bytes.length == count);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11355().allZero(bytes));
    }
}
