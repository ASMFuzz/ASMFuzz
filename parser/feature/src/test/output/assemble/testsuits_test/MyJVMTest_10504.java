import java.nio.charset.*;
import java.nio.*;
import java.util.*;

public class MyJVMTest_10504 {

    static byte[] bb = { 86, -34, -60, 114, -50, -44, -72, 47, -7, -19 };

    static Charset cs = null;

    static boolean testDirect = false;

    static long t = -6795831299701431259L;

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
        System.out.println(new MyJVMTest_10504().decodeCR(bb, cs, testDirect));
    }
}
