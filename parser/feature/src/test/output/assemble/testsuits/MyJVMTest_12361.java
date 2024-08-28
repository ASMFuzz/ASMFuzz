import java.nio.charset.*;
import java.nio.*;
import java.util.*;

public class MyJVMTest_12361 {

    static Charset cs = null;

    static byte[][] malformed = { { 103, 104, -25, -33, -106, 63, 60, -128, 38, -61 }, { -56, 23, -127, 39, 83, -98, 94, -115, 88, 83 } };

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

    static long t = -9223372036854775808L;

    static int iteration = 200;

    CoderResult checkMalformed(Charset cs, byte[][] malformed) throws Exception {
        boolean failed = false;
        String csn = cs.name();
        System.out.printf("Check malformed <%s>...%n", csn);
        for (boolean direct : new boolean[] { false, true }) {
            for (byte[] bins : malformed) {
                int mlen = bins[0];
                byte[] bin = Arrays.copyOfRange(bins, 1, bins.length);
                CoderResult cr = decodeCR(bin, cs, direct);
                String ashex = "";
                for (int i = 0; i < bin.length; i++) {
                    if (i > 0)
                        ashex += " ";
                    ashex += Integer.toString((int) bin[i] & 0xff, 16);
                }
                if (!cr.isMalformed()) {
                    System.out.printf("        FAIL(direct=%b): [%s] not malformed. -->cr=%s\n", direct, ashex, cr.toString());
                    failed = true;
                } else if (cr.length() != mlen) {
                    System.out.printf("        FAIL(direct=%b): [%s] malformed[len=%d].\n", direct, ashex, cr.length());
                    failed = true;
                }
            }
        }
        if (failed)
            throw new RuntimeException("Check malformed failed " + csn);
        return cr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12361().checkMalformed(cs, malformed);
    }
}
