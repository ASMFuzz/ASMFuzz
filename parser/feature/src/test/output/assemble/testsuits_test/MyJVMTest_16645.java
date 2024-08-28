import java.nio.charset.*;
import java.nio.*;

public class MyJVMTest_16645 {

    static String csName = "i|lgg,(7XJ";

    static byte[] ba = { -116, 50, -19, -63, 40, 88, 15, 124, -104, 118 };

    static int expected = 3;

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
        new MyJVMTest_16645().testDecode(csName, ba, expected);
    }
}
