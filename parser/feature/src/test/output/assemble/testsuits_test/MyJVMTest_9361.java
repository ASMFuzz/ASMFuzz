import java.util.*;
import java.util.zip.*;
import java.nio.*;

public class MyJVMTest_9361 {

    static Adler32 adler32 = new Adler32();

    static ByteBuffer buf = null;

    ByteBuffer testPosLimit(Adler32 adler32, ByteBuffer buf) {
        int pos = buf.position();
        int limit = buf.limit();
        adler32.update(buf);
        if (limit != buf.position() || limit != buf.limit()) {
            System.out.printf("%nFAILED: pos,limit=(%d, %d), expected (%d, %d)%n", buf.position(), buf.limit(), limit, limit);
            throw new RuntimeException();
        }
        buf.position(pos);
        return buf;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9361().testPosLimit(adler32, buf);
    }
}
