import java.nio.charset.*;
import java.nio.*;
import java.util.*;

public class MyJVMTest_1524 {

    static CharsetDecoder dec = null;

    static byte[] bytes = { -124, 124, -91, -108, -81, -24, -20, 85, -81, -6 };

    static boolean direct = true;

    static int[] flow = { 1, 1662859900, 0, 0, 406720505, 3, 6, 3, 0, -273982444 };

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
        System.out.println(new MyJVMTest_1524().check(dec, bytes, direct, flow));
    }
}
