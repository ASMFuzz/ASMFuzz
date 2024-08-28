import java.nio.charset.*;
import java.nio.*;
import java.util.*;

public class MyJVMTest_10287 {

    static Charset cs = null;

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

    static long t = -9223372036854775808L;

    int checkUnderOverflow(Charset cs) throws Exception {
        String csn = cs.name();
        System.out.printf("Check under/overflow <%s>...%n", csn);
        CharsetDecoder dec = cs.newDecoder();
        boolean failed = false;
        byte[] bytes = new String("\u007f\u3000\u4e42\u4e28\ud840\udc55").getBytes("EUC_TW");
        int inlen = bytes.length;
        int MAXOFF = 20;
        for (int inoff = 0; inoff < MAXOFF; inoff++) {
            for (int outoff = 0; outoff < MAXOFF; outoff++) {
                int[][] Flows = { { inoff, inlen, outoff, 1, inoff + 1, outoff + 1, 1 }, { inoff, inlen, outoff, 2, inoff + 3, outoff + 2, 1 }, { inoff, inlen, outoff, 3, inoff + 7, outoff + 3, 1 }, { inoff, inlen, outoff, 4, inoff + 11, outoff + 4, 1 }, { inoff, inlen, outoff, 5, inoff + 11, outoff + 4, 1 }, { inoff, inlen, outoff, 6, inoff + 15, outoff + 6, 0 }, { inoff, 1, outoff, 6, inoff + 1, outoff + 1, 0 }, { inoff, 2, outoff, 6, inoff + 1, outoff + 1, 0 }, { inoff, 3, outoff, 6, inoff + 3, outoff + 2, 0 }, { inoff, 4, outoff, 6, inoff + 3, outoff + 2, 0 }, { inoff, 5, outoff, 6, inoff + 3, outoff + 2, 0 }, { inoff, 8, outoff, 6, inoff + 7, outoff + 3, 0 }, { inoff, 9, outoff, 6, inoff + 7, outoff + 3, 0 }, { inoff, 10, outoff, 6, inoff + 7, outoff + 3, 0 }, { inoff, 11, outoff, 6, inoff + 11, outoff + 4, 0 }, { inoff, 12, outoff, 6, inoff + 11, outoff + 4, 0 }, { inoff, 15, outoff, 6, inoff + 15, outoff + 6, 0 }, { inoff, 2, outoff, 1, inoff + 1, outoff + 1, 0 }, { inoff, 3, outoff, 1, inoff + 1, outoff + 1, 1 }, { inoff, 3, outoff, 2, inoff + 3, outoff + 2, 0 } };
                for (boolean direct : new boolean[] { false, true }) {
                    for (int[] flow : Flows) {
                        if (!check(dec, bytes, direct, flow))
                            failed = true;
                    }
                }
            }
        }
        if (failed)
            throw new RuntimeException("Check under/overflow failed " + csn);
        return inlen;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10287().checkUnderOverflow(cs);
    }
}
