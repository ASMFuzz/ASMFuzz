import java.nio.charset.*;
import java.nio.*;
import java.util.*;

public class MyJVMTest_16646 {

    static String csn = "+~Cg!qU/A:";

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

    int checkUnderOverflow(String csn) throws Exception {
        System.out.printf("    Check under/overflow <%s>...%n", csn);
        CharsetDecoder dec = Charset.forName(csn).newDecoder();
        boolean failed = false;
        byte[] utf8s = new String("\u007f\u07ff\ue000\ud800\udc00").getBytes("UTF-8");
        int inlen = utf8s.length;
        for (int inoff = 0; inoff < 20; inoff++) {
            for (int outoff = 0; outoff < 20; outoff++) {
                int[][] Flows = { { inoff, inlen, outoff, 1, inoff + 1, outoff + 1, 1 }, { inoff, inlen, outoff, 2, inoff + 3, outoff + 2, 1 }, { inoff, inlen, outoff, 3, inoff + 6, outoff + 3, 1 }, { inoff, inlen, outoff, 4, inoff + 6, outoff + 3, 1 }, { inoff, inlen, outoff, 5, inoff + 10, outoff + 5, 0 }, { inoff, 1, outoff, 5, inoff + 1, outoff + 1, 0 }, { inoff, 2, outoff, 5, inoff + 1, outoff + 1, 0 }, { inoff, 3, outoff, 5, inoff + 3, outoff + 2, 0 }, { inoff, 4, outoff, 5, inoff + 3, outoff + 2, 0 }, { inoff, 5, outoff, 5, inoff + 3, outoff + 2, 0 }, { inoff, 6, outoff, 5, inoff + 6, outoff + 3, 0 }, { inoff, 7, outoff, 5, inoff + 6, outoff + 3, 0 }, { inoff, 8, outoff, 5, inoff + 6, outoff + 3, 0 }, { inoff, 9, outoff, 5, inoff + 6, outoff + 3, 0 }, { inoff, 10, outoff, 5, inoff + 10, outoff + 5, 0 }, { inoff, 2, outoff, 1, inoff + 1, outoff + 1, 0 }, { inoff, 3, outoff, 1, inoff + 1, outoff + 1, 1 }, { inoff, 4, outoff, 2, inoff + 3, outoff + 2, 0 }, { inoff, 5, outoff, 2, inoff + 3, outoff + 2, 0 }, { inoff, 6, outoff, 2, inoff + 3, outoff + 2, 1 }, { inoff, 7, outoff, 4, inoff + 6, outoff + 3, 0 }, { inoff, 8, outoff, 4, inoff + 6, outoff + 3, 0 }, { inoff, 9, outoff, 4, inoff + 6, outoff + 3, 0 }, { inoff, 10, outoff, 4, inoff + 6, outoff + 3, 1 } };
                for (boolean direct : new boolean[] { false, true }) {
                    for (int[] flow : Flows) {
                        if (!check(dec, utf8s, direct, flow))
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
        new MyJVMTest_16646().checkUnderOverflow(csn);
    }
}
