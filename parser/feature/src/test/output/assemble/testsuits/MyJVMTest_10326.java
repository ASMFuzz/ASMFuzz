import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_10326 {

    static byte[] encoded = { 100, -128, -128, 124, -102, -36, -41, -22, 41, -111 };

    static CoderResult expected = null;

    static String label = "0X3(:vA%It";

    boolean equal(CoderResult a, CoderResult b) {
        return (a == CoderResult.OVERFLOW && b == CoderResult.OVERFLOW) || (a == CoderResult.UNDERFLOW && b == CoderResult.UNDERFLOW) || ((a.isError() == b.isError()) && (a.isMalformed() == b.isMalformed()) && (a.isUnmappable() == b.isUnmappable()) && (a.length() == b.length()));
    }

    boolean decodeResultTest(byte[] encoded, CoderResult expected, String label) {
        CharsetDecoder dec = Charset.forName("ISO2022CN").newDecoder();
        ByteBuffer bb = ByteBuffer.wrap(encoded);
        CharBuffer cb = CharBuffer.allocate(encoded.length * (int) dec.maxCharsPerByte());
        CoderResult result = dec.decode(bb, cb, true);
        if (!equal(result, expected)) {
            System.err.println(label + ": decoder's decode() failed!");
            return false;
        }
        bb = ByteBuffer.allocateDirect(encoded.length).put(encoded);
        bb.flip();
        cb = ByteBuffer.allocateDirect(2 * encoded.length * (int) dec.maxCharsPerByte()).asCharBuffer();
        if (bb.hasArray() || cb.hasArray()) {
            System.err.println(label + ": directBuffer failed, ");
            return false;
        }
        result = dec.reset().decode(bb, cb, true);
        if (!equal(result, expected)) {
            System.err.println(label + ": decoder's decode() - direct failed!");
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10326().decodeResultTest(encoded, expected, label));
    }
}
