import java.util.*;
import java.util.zip.*;
import java.nio.*;

public class MyJVMTest_17485 {

    static CRC32 crc32 = new CRC32();

    static ByteBuffer buf = null;

    ByteBuffer testPosLimit(CRC32 crc32, ByteBuffer buf) {
        int pos = buf.position();
        int limit = buf.limit();
        crc32.update(buf);
        if (limit != buf.position() || limit != buf.limit()) {
            System.out.printf("%nFAILED: pos,limit=(%d, %d), expected (%d, %d)%n", buf.position(), buf.limit(), limit, limit);
            throw new RuntimeException();
        }
        buf.position(pos);
        return buf;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17485().testPosLimit(crc32, buf);
    }
}
