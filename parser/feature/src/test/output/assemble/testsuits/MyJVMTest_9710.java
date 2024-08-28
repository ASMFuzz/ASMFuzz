import java.util.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_9710 {

    static Charset cs = null;

    static String str = "$@ydCB3996";

    byte[] getBytes(CharsetEncoder enc, String str) throws Throwable {
        ByteBuffer bf = enc.reset().encode(CharBuffer.wrap(str.toCharArray()));
        byte[] ba = new byte[bf.limit()];
        bf.get(ba, 0, ba.length);
        return ba;
    }

    byte[] testGetBytes(Charset cs, String str) throws Throwable {
        CharsetEncoder enc = cs.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
        byte[] baSC = str.getBytes(cs.name());
        byte[] baNIO = getBytes(enc, str);
        if (!Arrays.equals(baSC, baNIO)) {
            throw new RuntimeException("getBytes(csn) failed  -> " + cs.name());
        }
        baSC = str.getBytes(cs);
        if (!Arrays.equals(baSC, baNIO)) {
            throw new RuntimeException("getBytes(cs) failed  -> " + cs.name());
        }
        return baSC;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_9710().testGetBytes(cs, str)));
    }
}
