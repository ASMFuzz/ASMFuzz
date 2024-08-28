import java.nio.charset.*;
import java.nio.*;
import java.util.*;

public class MyJVMTest_9628 {

    static byte[] bb = { -25, -36, -24, -62, 71, 92, -4, 73, -54, -42 };

    static String csn = "Q&#Bn+xU&q";

    static boolean testDirect = true;

    CoderResult decodeCR(byte[] bb, String csn, boolean testDirect) throws Exception {
        CharsetDecoder dec = Charset.forName(csn).newDecoder();
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
        return dec.decode(bbf, cbf, true);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9628().decodeCR(bb, csn, testDirect));
    }
}
