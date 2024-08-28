import java.util.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_5609 {

    static Charset cs = null;

    static byte[] ba = { -17, 49, 32, -25, 40, -55, 65, -74, -30, -74 };

    String testNewString(Charset cs, byte[] ba) throws Throwable {
        CharsetDecoder dec = cs.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
        String strSC = new String(ba, cs.name());
        String strNIO = dec.reset().decode(ByteBuffer.wrap(ba)).toString();
        if (!strNIO.equals(strSC)) {
            throw new RuntimeException("new String(csn) failed  -> " + cs.name());
        }
        strSC = new String(ba, cs);
        if (!strNIO.equals(strSC)) {
            throw new RuntimeException("new String(cs)/bmp failed  -> " + cs.name());
        }
        return strSC;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5609().testNewString(cs, ba));
    }
}
