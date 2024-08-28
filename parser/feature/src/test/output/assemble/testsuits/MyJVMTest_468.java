import java.nio.charset.*;
import java.nio.*;
import java.util.*;

public class MyJVMTest_468 {

    static byte[] bb = { -86, -94, -25, 106, -30, 56, -73, 44, -6, 110 };

    static String csn = "fasoxgI?OC";

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
        System.out.println(new MyJVMTest_468().decodeCR(bb, csn, testDirect));
    }
}
