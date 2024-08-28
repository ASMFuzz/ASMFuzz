import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_6146 {

    static byte[] inputBytes = { 118, -35, -17, 73, 57, 34, 42, -93, -10, -88 };

    static String expectedStr = " 'Bg_ v80p";

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
        new MyJVMTest_6146().decodeTest(inputBytes, expectedStr);
    }
}
