import java.nio.charset.*;
import java.nio.*;
import java.util.*;

public class MyJVMTest_260 {

    static char c = Character.MAX_VALUE;

    static byte[] bb = { -12, 8, 62, -36, -98, -106, 85, -60, -31, 84 };

    static int pos = 6;

    int to3ByteUTF8(char c, byte[] bb, int pos) {
        bb[pos++] = (byte) (0xe0 | ((c >> 12)));
        bb[pos++] = (byte) (0x80 | ((c >> 06) & 0x3f));
        bb[pos++] = (byte) (0x80 | ((c >> 00) & 0x3f));
        return 3;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_260().to3ByteUTF8(c, bb, pos));
    }
}
