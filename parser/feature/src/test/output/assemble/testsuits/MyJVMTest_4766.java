import java.nio.charset.*;
import java.nio.*;
import java.util.*;

public class MyJVMTest_4766 {

    static char[] cc = { '0', Character.MAX_VALUE, '0', '0', Character.MAX_VALUE, Character.MAX_VALUE, '0', Character.MIN_VALUE, '0', Character.MIN_VALUE };

    static String csn = "h;C'<c,im\"";

    static boolean testDirect = false;

    CoderResult encodeCR(char[] cc, String csn, boolean testDirect) throws Exception {
        ByteBuffer bbf;
        CharBuffer cbf;
        CharsetEncoder enc = Charset.forName(csn).newEncoder();
        if (testDirect) {
            bbf = ByteBuffer.allocateDirect(cc.length * 4);
            cbf = ByteBuffer.allocateDirect(cc.length * 2).asCharBuffer();
            cbf.put(cc).flip();
        } else {
            bbf = ByteBuffer.allocate(cc.length * 4);
            cbf = CharBuffer.wrap(cc);
        }
        return enc.encode(cbf, bbf, true);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4766().encodeCR(cc, csn, testDirect));
    }
}
