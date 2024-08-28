import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_1984 {

    static String inputString = "*l/+gg.]sT";

    static byte[] expectedBytes = { -127, 39, 41, -113, 103, -1, 97, -106, -128, 83 };

    byte[] encodeTest(String inputString, byte[] expectedBytes) throws Exception {
        byte[] encoded = inputString.getBytes("GB18030");
        CharBuffer cb = CharBuffer.wrap(inputString.toCharArray());
        ByteBuffer bb = ByteBuffer.allocate(4);
        CharsetEncoder encoder = Charset.forName("GB18030").newEncoder();
        encoder.encode(cb, bb, true);
        bb.flip();
        for (int i = 0; i < expectedBytes.length; i++) {
            if (encoded[i] != expectedBytes[i] || bb.get() != expectedBytes[i])
                throw new Exception("GB18030 encode failure");
        }
        return expectedBytes;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1984().encodeTest(inputString, expectedBytes);
    }
}
