import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_16584 {

    static String csn = "*Ss=(?\"Oin";

    static byte[] bytes = { -115, -23, 99, 6, 98, -24, 20, 9, -109, 61 };

    CoderResult test(String csn, byte[] bytes) throws Throwable {
        CharsetDecoder dec = Charset.forName(csn).newDecoder();
        CharBuffer cb = CharBuffer.allocate(1024);
        CoderResult cr = dec.decode(ByteBuffer.wrap(bytes), cb, true);
        if (cr.isUnderflow())
            throw new RuntimeException(csn + " failed cr=" + cr);
        return cr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16584().test(csn, bytes);
    }
}
