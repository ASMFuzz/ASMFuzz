import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_3124 {

    static ByteBuffer buf = null;

    static int offset = 3;

    static int len = 0;

    static ByteBuffer dataDirect = null;

    static int deflatedLength = 8;

    static int srcMode = -1372622676, dstMode = 6;

    int validate(ByteBuffer buf, int offset, int len) throws Exception {
        for (int i = 0; i < len; i++) {
            if (buf.get(i) != dataDirect.get(offset + i)) {
                throw new Exception("mismatch at " + (offset + i));
            }
        }
        return offset;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3124().validate(buf, offset, len);
    }
}
