import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import javax.crypto.interfaces.*;
import java.util.*;

public class MyJVMTest_14463 {

    static byte[] bytes = { -113, -4, -116, 40, 40, -37, -94, -16, -126, -94 };

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
        System.out.println(new MyJVMTest_14463().toHexString(bytes));
    }
}
