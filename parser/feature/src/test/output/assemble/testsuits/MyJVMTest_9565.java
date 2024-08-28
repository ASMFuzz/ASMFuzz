import java.nio.charset.*;
import java.nio.*;
import java.util.*;

public class MyJVMTest_9565 {

    static int uc = 2086532540;

    static byte[] bb = { -94, -124, 31, -99, 95, -63, 44, -88, 46, 41 };

    static int pos = 0;

    int to4ByteUTF8(int uc, byte[] bb, int pos) {
        bb[pos++] = (byte) (0xf0 | ((uc >> 18)));
        bb[pos++] = (byte) (0x80 | ((uc >> 12) & 0x3f));
        bb[pos++] = (byte) (0x80 | ((uc >> 6) & 0x3f));
        bb[pos++] = (byte) (0x80 | (uc & 0x3f));
        return 4;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9565().to4ByteUTF8(uc, bb, pos));
    }
}
