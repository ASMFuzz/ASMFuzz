import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.util.*;

public class MyJVMTest_10415 {

    static String csn = "15)9{#HvsZ";

    static byte[] repl = { 20, -121, -50, -104, -109, 89, 28, 85, 79, 67 };

    CoderResult ilr(String csn, byte[] repl) {
        CharsetDecoder dec = Charset.forName(csn).newDecoder();
        dec.onMalformedInput(CodingErrorAction.REPORT);
        dec.onUnmappableCharacter(CodingErrorAction.REPORT);
        ByteBuffer bb = ByteBuffer.wrap(repl);
        CharBuffer cb = CharBuffer.allocate((int) (bb.remaining() * dec.maxCharsPerByte()));
        return dec.decode(bb, cb, true);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10415().ilr(csn, repl));
    }
}
