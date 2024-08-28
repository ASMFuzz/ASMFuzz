import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import javax.crypto.interfaces.*;
import java.util.*;

public class MyJVMTest_18006 {

    static String value = "{P21\\,2.kt";

    byte[] fromHexString(String value) {
        byte[] bytes = new byte[value.length() / 2];
        String mapping = "0123456789abcdef";
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            String high = value.substring(2 * i, 2 * i + 1);
            String low = value.substring(2 * i + 1, 2 * i + 2);
            bytes[i] = (byte) ((mapping.indexOf(high) << 4) + mapping.indexOf(low));
        }
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_18006().fromHexString(value)));
    }
}
