import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_9444 {

    static CharsetEncoder enc = null;

    static char[] inputChars = { 'd', Character.MIN_VALUE, 'P', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE, '&', Character.MIN_VALUE };

    static byte[] expectedBytes = { 68, -95, 122, 42, 19, -32, 39, 68, -65, 28 };

    static char[][] in = { { '\u25cb', '\u2460', '\u25cb' }, { '\u0061', '\u2460', '\u0061' }, { '\u25cb', '\u2460', '\u25cb' }, { '\u0061', '\u2460', '\u0061' } };

    static byte[][] expected = { { 0x1b, 0x24, 0x42, 0x21, 0x7b, 0x21, 0x29, 0x21, 0x7b, 0x1b, 0x28, 0x42 }, { 0x61, 0x1b, 0x24, 0x42, 0x21, 0x29, 0x1b, 0x28, 0x42, 0x61 }, { 0x1b, 0x24, 0x42, 0x21, 0x7b, 0x1b, 0x28, 0x42, 0x3f, 0x1b, 0x24, 0x42, 0x21, 0x7b, 0x1b, 0x28, 0x42 }, { 0x61, 0x3f, 0x61 } };

    ByteBuffer test(CharsetEncoder enc, char[] inputChars, byte[] expectedBytes) throws Exception {
        ByteBuffer bb = ByteBuffer.allocate(expectedBytes.length);
        enc.encode(CharBuffer.wrap(inputChars), bb, true);
        enc.flush(bb);
        bb.flip();
        byte[] outputBuff = bb.array();
        int outputLen = bb.limit();
        if (outputLen != expectedBytes.length) {
            throw new Exception("Output bytes does not match");
        }
        for (int i = 0; i < outputLen; ++i) {
            System.out.printf("<%x:%x> ", expectedBytes[i] & 0xff, outputBuff[i] & 0xff);
            if (expectedBytes[i] != outputBuff[i]) {
                System.out.println("...");
                throw new Exception("Output bytes does not match");
            }
        }
        System.out.println();
        return bb;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9444().test(enc, inputChars, expectedBytes);
    }
}
