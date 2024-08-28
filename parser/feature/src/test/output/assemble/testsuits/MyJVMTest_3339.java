import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_3339 {

    static String charset = "#B\\#jKr`xs";

    static String input = "|aO//6_*]d";

    static byte[] expected = { -106, 111, -110, -72, -25, -14, 21, 96, 15, -83 };

    byte[] testEncode(String charset, String input, byte[] expected) throws Exception {
        byte[] testBytes = input.getBytes(charset);
        for (int i = 0; i < expected.length; i++) if (testBytes[i] != expected[i])
            throw new Exception("UTF_16 Encoding test failed " + charset);
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3339().testEncode(charset, input, expected);
    }
}
