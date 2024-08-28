import java.util.*;
import java.util.zip.*;
import java.util.jar.*;
import java.io.*;

public class MyJVMTest_1716 {

    static byte[] b = { -68, -21, -59, -58, -97, -69, -86, 98, 94, 46 };

    static int off = 1579393349;

    static String name = "^!|WDMT~h[";

    static int method = -1421346626;

    static byte[] data = {60,125,-125,109,-126,-117,65,-83,89,72};

    static byte[] extra = {108,-63,-71,-17,11,48,4,-67,27,29};

    static String comment = "D-=0#OK[H;";

    int get16(byte[] b, int off) {
        return Byte.toUnsignedInt(b[off]) | (Byte.toUnsignedInt(b[off + 1]) << 8);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1716().get16(b, off));
    }
}
