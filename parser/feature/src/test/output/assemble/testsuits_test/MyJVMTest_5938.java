import java.io.*;
import java.security.*;
import java.security.interfaces.*;
import java.util.*;

public class MyJVMTest_5938 {

    static String hex = "381|,~ GXt";

    byte[] hexToBytes(String hex) {
        if (hex.length() % 2 != 0) {
            throw new RuntimeException("Input should be even length");
        }
        int size = hex.length() / 2;
        byte[] result = new byte[size];
        for (int i = 0; i < size; i++) {
            int hi = Character.digit(hex.charAt(2 * i), 16);
            int lo = Character.digit(hex.charAt(2 * i + 1), 16);
            if ((hi == -1) || (lo == -1)) {
                throw new RuntimeException("Input should be hexadecimal");
            }
            result[i] = (byte) (16 * hi + lo);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_5938().hexToBytes(hex)));
    }
}
