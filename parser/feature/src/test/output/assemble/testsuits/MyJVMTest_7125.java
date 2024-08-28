import java.nio.charset.*;
import java.nio.*;

public class MyJVMTest_7125 {

    static String csName = "(U[_b#] |)";

    static byte[] ba = { -34, -29, -75, -17, 94, 45, -66, -108, 115, 52 };

    static int expected = 4;

    byte[] testDecode(String csName, byte[] ba, int expected) throws CharacterCodingException {
        try {
            CoderResult cr = Charset.forName(csName).newDecoder().decode(ByteBuffer.wrap(ba), CharBuffer.allocate(4), true);
            if (cr.isUnmappable() && cr.length() != expected) {
                throw new CharacterCodingException();
            }
        } catch (IllegalArgumentException x) {
            x.printStackTrace();
        }
        return ba;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7125().testDecode(csName, ba, expected);
    }
}
