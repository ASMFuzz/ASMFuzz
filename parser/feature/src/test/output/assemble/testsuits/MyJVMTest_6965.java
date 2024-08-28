import java.nio.charset.*;
import java.nio.*;
import java.util.*;

public class MyJVMTest_6965 {

    static CharsetDecoder dec = null;

    static byte[] utf8s = { 31, -100, -34, 112, 85, 92, -53, -115, -87, 44 };

    static boolean direct = true;

    static int[] flow = { -386972048, 5, 239325607, 6, 0, 0, 0, 7, 7, 0 };

    boolean check(CharsetDecoder dec, byte[] utf8s, boolean direct, int[] flow) {
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
            bbf = ByteBuffer.allocateDirect(inPos + utf8s.length);
            cbf = ByteBuffer.allocateDirect((outPos + outLen) * 2).asCharBuffer();
        } else {
            bbf = ByteBuffer.allocate(inPos + utf8s.length);
            cbf = CharBuffer.allocate(outPos + outLen);
        }
        bbf.position(inPos);
        bbf.put(utf8s).flip().position(inPos).limit(inPos + inLen);
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
        System.out.println(new MyJVMTest_6965().check(dec, utf8s, direct, flow));
    }
}
