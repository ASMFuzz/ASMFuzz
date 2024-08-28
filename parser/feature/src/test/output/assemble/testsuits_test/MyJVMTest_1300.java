import java.nio.charset.*;
import java.nio.*;
import java.util.*;

public class MyJVMTest_1300 {

    static byte[] bb = { 48, 98, 116, 72, -124, 102, -78, -69, -84, -4 };

    static Charset cs = null;

    static boolean testDirect = true;

    static long t = 9223372036854775807L;

    static int iteration = 200;

    CoderResult decodeCR(byte[] bb, Charset cs, boolean testDirect) throws Exception {
        CharsetDecoder dec = cs.newDecoder();
        ByteBuffer bbf;
        CharBuffer cbf;
        if (testDirect) {
            bbf = ByteBuffer.allocateDirect(bb.length);
            cbf = ByteBuffer.allocateDirect(bb.length * 2).asCharBuffer();
            bbf.put(bb).flip();
        } else {
            bbf = ByteBuffer.wrap(bb);
            cbf = CharBuffer.allocate(bb.length);
        }
        CoderResult cr = null;
        for (int i = 0; i < iteration; i++) {
            bbf.rewind();
            cbf.clear();
            dec.reset();
            cr = dec.decode(bbf, cbf, true);
        }
        return cr;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1300().decodeCR(bb, cs, testDirect));
    }
}
