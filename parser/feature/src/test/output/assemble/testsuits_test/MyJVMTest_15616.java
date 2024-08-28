import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_15616 {

    static byte[] inputBytes = { -67, -77, 37, 4, 81, 69, -17, 62, 94, 66 };

    static String expectedStr = "3w S/F%kLN";

    CharBuffer decodeTest(byte[] inputBytes, String expectedStr) throws Exception {
        String s2 = new String(inputBytes, "GB18030");
        CharsetDecoder decoder = Charset.forName("GB18030").newDecoder();
        ByteBuffer bb = ByteBuffer.wrap(inputBytes);
        CharBuffer cb = CharBuffer.allocate(2);
        decoder.decode(bb, cb, true);
        cb.flip();
        for (int i = 0; i < expectedStr.length(); i++) {
            if (expectedStr.charAt(i) != cb.get() || s2.charAt(i) != expectedStr.charAt(i))
                throw new Exception("GB18030 encode failure");
        }
        return cb;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15616().decodeTest(inputBytes, expectedStr);
    }
}
