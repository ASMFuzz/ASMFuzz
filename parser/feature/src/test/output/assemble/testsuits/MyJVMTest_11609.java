import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.util.*;

public class MyJVMTest_11609 {

    static String csn = "%[<?Fr;TAW";

    static byte[] repl = { -52, -100, -57, -65, -40, 34, 3, -106, -66, 57 };

    static boolean expected = false;

    String toString(byte[] ba) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ba.length; i++) {
            byte b = ba[i];
            if (i > 0)
                sb.append(' ');
            sb.append(Integer.toHexString((b >> 4) & 0xf));
            sb.append(Integer.toHexString((b >> 0) & 0xf));
        }
        return sb.toString();
    }

    CoderResult ilr(String csn, byte[] repl) {
        CharsetDecoder dec = Charset.forName(csn).newDecoder();
        dec.onMalformedInput(CodingErrorAction.REPORT);
        dec.onUnmappableCharacter(CodingErrorAction.REPORT);
        ByteBuffer bb = ByteBuffer.wrap(repl);
        CharBuffer cb = CharBuffer.allocate((int) (bb.remaining() * dec.maxCharsPerByte()));
        return dec.decode(bb, cb, true);
    }

    static PrintStream out = System.err;

    static int errors = 0;

    String test(String csn, byte[] repl, boolean expected) throws Exception {
        CharsetEncoder enc = Charset.forName(csn).newEncoder();
        out.print(csn + ": " + toString(repl) + ": ");
        if (enc.isLegalReplacement(repl) == expected) {
            out.print("Okay");
        } else {
            out.print("Wrong: Expected " + expected);
            errors++;
        }
        out.println(" (" + ilr(csn, repl) + ")");
        return csn;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11609().test(csn, repl, expected);
    }
}
