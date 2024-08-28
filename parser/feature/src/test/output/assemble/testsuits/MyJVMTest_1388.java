import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_1388 {

    static String charset = "b_B ':-YT#";

    static String input = "Hp7H{!Z@8>";

    static byte[] expected = { -52, 102, 12, -107, 49, 45, -38, 87, 94, 22 };

    byte[] testEncode(String charset, String input, byte[] expected) throws Exception {
        byte[] testBytes = input.getBytes(charset);
        for (int i = 0; i < expected.length; i++) if (testBytes[i] != expected[i])
            throw new Exception("UTF_32 Encoding test failed: [" + i + "]" + charset);
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1388().testEncode(charset, input, expected);
    }
}
