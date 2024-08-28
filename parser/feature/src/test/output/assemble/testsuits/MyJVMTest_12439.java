import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_12439 {

    static ByteBuffer buf = null;

    static int offset = -703923012;

    static int len = 687960423;

    static ByteBuffer dataDirect = null;

    static int deflatedLength = 0;

    static int srcMode = 0, dstMode = 2;

    int validate(ByteBuffer buf, int offset, int len) throws Exception {
        for (int i = 0; i < len; i++) {
            if (buf.get(i) != dataDirect.get(offset + i)) {
                throw new Exception("mismatch at " + (offset + i));
            }
        }
        return offset;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12439().validate(buf, offset, len);
    }
}
