import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_12666 {

    static String charset = "R.>TdEG#l.";

    static String input = "*-6*B~PU'|";

    static byte[] expected = { -101, 75, -48, 26, -5, -121, 113, -122, 49, 14 };

    byte[] testEncode(String charset, String input, byte[] expected) throws Exception {
        byte[] testBytes = input.getBytes(charset);
        for (int i = 0; i < expected.length; i++) if (testBytes[i] != expected[i])
            throw new Exception("UTF_16 Encoding test failed " + charset);
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12666().testEncode(charset, input, expected);
    }
}
