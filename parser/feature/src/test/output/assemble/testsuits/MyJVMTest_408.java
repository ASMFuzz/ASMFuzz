import java.nio.charset.*;
import java.nio.*;
import java.util.*;

public class MyJVMTest_408 {

    static int uc = -1086761079;

    static byte[] bb = { 22, 55, 53, -99, -51, 4, -11, -30, 56, -2 };

    static int pos = 0;

    int to4ByteUTF8(int uc, byte[] bb, int pos) {
        bb[pos++] = (byte) (0xf0 | ((uc >> 18)));
        bb[pos++] = (byte) (0x80 | ((uc >> 12) & 0x3f));
        bb[pos++] = (byte) (0x80 | ((uc >> 6) & 0x3f));
        bb[pos++] = (byte) (0x80 | (uc & 0x3f));
        return 4;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_408().to4ByteUTF8(uc, bb, pos));
    }
}
