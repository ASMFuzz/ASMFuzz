import java.util.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_16731 {

    static Charset cs = null;

    static char c = Character.MIN_VALUE;

    static CharBuffer cb = null;

    ByteBuffer convert(Charset cs, char c, CharBuffer cb) throws Throwable {
        cb.clear();
        cb.put(c);
        cb.flip();
        return cs.newEncoder().onUnmappableCharacter(CodingErrorAction.REPLACE).onMalformedInput(CodingErrorAction.REPLACE).encode(cb);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16731().convert(cs, c, cb));
    }
}
