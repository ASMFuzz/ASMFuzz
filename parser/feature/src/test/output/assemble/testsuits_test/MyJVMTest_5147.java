import java.util.*;
import java.util.zip.*;
import java.util.jar.*;
import java.io.*;

public class MyJVMTest_5147 {

    static byte[] expected = { 42, -12, 23, -101, 125, -44, 47, -62, 71, -21 };

    int get16(byte[] b, int off) {
        return Byte.toUnsignedInt(b[off]) | (Byte.toUnsignedInt(b[off + 1]) << 8);
    }

    static String name = "[k.*WS1FH_";

    static int method = 7;

    static byte[] data = {43,13,-120,7,-47,-39,21,-124,-18,-78};

    static byte[] extra = {-108,20,-75,3,62,14,-25,-2,123,-100};

    static String comment = "ms?5GfuvJi";

    boolean equalsExtraData(byte[] expected, byte[] extra) {
        if (expected == null)
            return true;
        int off = 0;
        int len = expected.length;
        while (off + 4 < len) {
            int tag = get16(expected, off);
            int sz = get16(expected, off + 2);
            int off0 = 0;
            int len0 = extra.length;
            boolean matched = false;
            while (off0 + 4 < len0) {
                int tag0 = get16(extra, off0);
                int sz0 = get16(extra, off0 + 2);
                if (tag == tag0 && sz == sz0) {
                    matched = true;
                    for (int i = 0; i < sz; i++) {
                        if (expected[off + i] != extra[off0 + i])
                            matched = false;
                    }
                    break;
                }
                off0 += (4 + sz0);
            }
            if (!matched)
                return false;
            off += (4 + sz);
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5147().equalsExtraData(expected, extra));
    }
}
