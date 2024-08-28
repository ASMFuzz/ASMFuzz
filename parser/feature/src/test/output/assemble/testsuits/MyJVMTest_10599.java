import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_10599 {

    static String charset = "*TV]F^(yp>";

    static String input = "/i\"5CP-%l[";

    static byte[] expected = { 11, 17, -124, 74, -4, 45, -41, 1, -95, -80 };

    byte[] testEncode(String charset, String input, byte[] expected) throws Exception {
        byte[] testBytes = input.getBytes(charset);
        for (int i = 0; i < expected.length; i++) if (testBytes[i] != expected[i])
            throw new Exception("UTF_32 Encoding test failed: [" + i + "]" + charset);
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10599().testEncode(charset, input, expected);
    }
}
