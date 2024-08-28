import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import javax.crypto.interfaces.*;
import java.util.*;

public class MyJVMTest_5051 {

    static byte[] bytes = { -67, -46, -15, 36, 29, 41, 48, -105, 25, 23 };

    String toHexString(byte[] bytes) {
        String mapping = "0123456789abcdef";
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            int low = bytes[i] & 0x0f;
            int high = ((bytes[i] >> 4) & 0x0f);
            char[] res = new char[2];
            res[0] = mapping.charAt(high);
            res[1] = mapping.charAt(low);
            sb.append(res);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5051().toHexString(bytes));
    }
}
