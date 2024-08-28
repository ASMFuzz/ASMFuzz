import java.nio.charset.*;
import java.nio.*;
import java.util.*;

public class MyJVMTest_17488 {

    static char[] cc = { Character.MIN_VALUE, '0', 't', Character.MAX_VALUE, '0', '*', Character.MIN_VALUE, Character.MIN_VALUE, 'Q', '0' };

    static Charset cs = null;

    static boolean testDirect = false;

    static long t = 9223372036854775807L;

    static int iteration = 200;

    CoderResult encodeCR(char[] cc, Charset cs, boolean testDirect) throws Exception {
        ByteBuffer bbf;
        CharBuffer cbf;
        CharsetEncoder enc = cs.newEncoder();
        if (testDirect) {
            bbf = ByteBuffer.allocateDirect(cc.length * 4);
            cbf = ByteBuffer.allocateDirect(cc.length * 2).asCharBuffer();
            cbf.put(cc).flip();
        } else {
            bbf = ByteBuffer.allocate(cc.length * 4);
            cbf = CharBuffer.wrap(cc);
        }
        CoderResult cr = null;
        for (int i = 0; i < iteration; i++) {
            cbf.rewind();
            bbf.clear();
            enc.reset();
            cr = enc.encode(cbf, bbf, true);
        }
        return cr;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17488().encodeCR(cc, cs, testDirect));
    }
}
