import java.nio.charset.*;
import java.nio.*;
import java.util.*;

public class MyJVMTest_10743 {

    static CharsetDecoder dec = null;

    static byte[] bytes = { -45, -73, 104, 114, -123, 53, -66, -51, -70, 35 };

    static boolean direct = false;

    static int[] flow = { 2, 8, -2012026028, 0, 0, 0, 0, 2, 1061581341, 0 };

    static long t = 9223372036854775807L;

    boolean check(CharsetDecoder dec, byte[] bytes, boolean direct, int[] flow) {
        int inPos = flow[0];
        int inLen = flow[1];
        int outPos = flow[2];
        int outLen = flow[3];
        int expedInPos = flow[4];
        int expedOutPos = flow[5];
        CoderResult expedCR = (flow[6] == 0) ? CoderResult.UNDERFLOW : CoderResult.OVERFLOW;
        ByteBuffer bbf;
        CharBuffer cbf;
        if (direct) {
            bbf = ByteBuffer.allocateDirect(inPos + bytes.length);
            cbf = ByteBuffer.allocateDirect((outPos + outLen) * 2).asCharBuffer();
        } else {
            bbf = ByteBuffer.allocate(inPos + bytes.length);
            cbf = CharBuffer.allocate(outPos + outLen);
        }
        bbf.position(inPos);
        bbf.put(bytes).flip().position(inPos).limit(inPos + inLen);
        cbf.position(outPos);
        dec.reset();
        CoderResult cr = dec.decode(bbf, cbf, false);
        if (cr != expedCR || bbf.position() != expedInPos || cbf.position() != expedOutPos) {
            System.out.printf("Expected(direct=%5b): [", direct);
            for (int i : flow) System.out.print(" " + i);
            System.out.println("]  CR=" + cr + ", inPos=" + bbf.position() + ", outPos=" + cbf.position());
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10743().check(dec, bytes, direct, flow));
    }
}
