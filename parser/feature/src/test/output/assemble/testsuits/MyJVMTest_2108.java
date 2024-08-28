import java.security.*;
import java.util.*;
import javax.crypto.*;

public class MyJVMTest_2108 {

    static byte[] bytes = { -123, 17, 3, -8, 42, 38, 113, 47, -68, 121 };

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
        System.out.println(new MyJVMTest_2108().allZero(bytes));
    }
}
