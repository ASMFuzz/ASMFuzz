import java.security.*;
import java.security.spec.*;
import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_9773 {

    static byte[] data = { -71, 115, 9, 31, -46, -47, 38, -44, 107, -9 };

    static int count = 4;

    static Cipher cipher = null;

    static IvParameterSpec params = null;

    static SecretKey cipherKey = null;

    static StringBuffer col = null;

    static int sum = 0;

    byte[] runTest(byte[] data, int count) throws Exception {
        long start, end;
        cipher.init(Cipher.ENCRYPT_MODE, cipherKey, params);
        start = System.currentTimeMillis();
        for (int i = 0; i < count - 1; i++) {
            cipher.update(data, 0, data.length);
        }
        cipher.doFinal(data, 0, data.length);
        end = System.currentTimeMillis();
        int speed = (int) ((data.length * count) / (end - start));
        sum += speed;
        col.append(speed);
        return data;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9773().runTest(data, count);
    }
}
