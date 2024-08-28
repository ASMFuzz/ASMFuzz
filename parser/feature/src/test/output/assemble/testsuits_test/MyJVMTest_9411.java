import java.nio.charset.*;
import java.nio.*;
import java.util.*;

public class MyJVMTest_9411 {

    static char c = '0';

    static byte[] bb = { 5, -31, 93, -51, -127, 42, 40, -59, -33, 102 };

    static int pos = 1217793692;

    int to3ByteUTF8(char c, byte[] bb, int pos) {
        bb[pos++] = (byte) (0xe0 | ((c >> 12)));
        bb[pos++] = (byte) (0x80 | ((c >> 06) & 0x3f));
        bb[pos++] = (byte) (0x80 | ((c >> 00) & 0x3f));
        return 3;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9411().to3ByteUTF8(c, bb, pos));
    }
}
