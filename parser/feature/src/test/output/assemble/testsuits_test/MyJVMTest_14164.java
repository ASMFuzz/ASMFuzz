import java.nio.charset.*;
import java.nio.*;
import java.util.*;

public class MyJVMTest_14164 {

    static char[] cc = { Character.MIN_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '1', '0', '0', '0' };

    static String csn = "q+W+ztp70|";

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
        System.out.println(new MyJVMTest_14164().encodeCR(cc, csn, testDirect));
    }
}
