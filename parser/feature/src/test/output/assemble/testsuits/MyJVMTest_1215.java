import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.util.*;

public class MyJVMTest_1215 {

    static String csn = " |r@n'N,\\<";

    static byte[] repl = { -123, -125, 39, 16, 119, -82, 38, -113, 125, -81 };

    CoderResult ilr(String csn, byte[] repl) {
        CharsetDecoder dec = Charset.forName(csn).newDecoder();
        dec.onMalformedInput(CodingErrorAction.REPORT);
        dec.onUnmappableCharacter(CodingErrorAction.REPORT);
        ByteBuffer bb = ByteBuffer.wrap(repl);
        CharBuffer cb = CharBuffer.allocate((int) (bb.remaining() * dec.maxCharsPerByte()));
        return dec.decode(bb, cb, true);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1215().ilr(csn, repl));
    }
}
