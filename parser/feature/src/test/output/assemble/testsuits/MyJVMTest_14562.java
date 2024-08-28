import java.util.*;
import java.util.zip.*;
import java.util.jar.*;
import java.io.*;

public class MyJVMTest_14562 {

    static byte[] expected = { 125, -6, -31, -123, 120, -119, -59, 23, -16, -33 };

    int get16(byte[] b, int off) {
        return Byte.toUnsignedInt(b[off]) | (Byte.toUnsignedInt(b[off + 1]) << 8);
    }

    static String name = "_ScL(@S=hU";

    static int method = 936851952;

    static byte[] data = {14,-121,-107,-118,80,7,38,108,79,124};

    static byte[] extra = {-85,118,110,65,23,24,25,95,106,12};

    static String comment = "]KzY+%G_Cv";

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
        System.out.println(new MyJVMTest_14562().equalsExtraData(expected, extra));
    }
}
