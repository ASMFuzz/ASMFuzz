import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_7066 {

    static String csn = "xX|vw7~5W ";

    static byte[] bytes = { -91, 15, 106, -118, -111, 2, 98, -57, -56, 109 };

    CoderResult test(String csn, byte[] bytes) throws Throwable {
        CharsetDecoder dec = Charset.forName(csn).newDecoder();
        CharBuffer cb = CharBuffer.allocate(1024);
        CoderResult cr = dec.decode(ByteBuffer.wrap(bytes), cb, true);
        if (cr.isUnderflow())
            throw new RuntimeException(csn + " failed cr=" + cr);
        return cr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7066().test(csn, bytes);
    }
}
