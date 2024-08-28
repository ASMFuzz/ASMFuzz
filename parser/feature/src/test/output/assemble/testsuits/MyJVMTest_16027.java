import java.io.*;
import java.nio.charset.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_16027 {

    static byte[] isParam1 = { 23, 14, -64, -22, -49, -114, 116, -43, 29, 83 };

    static int isParam2 = 785;

    static int isParam3 = 87;

    static InputStream is = new ByteArrayInputStream(isParam1, isParam2, isParam3);

    static Charset cs = null;

    static String name = "Qgr`S_`x&e";

    static String comment = "p7%[#%x\"-&";

    static byte[] bb = { -100, 37, -110, 79, 21, -18, 126, -23, 42, -9 };

    byte[] testZipInputStream(InputStream is, Charset cs, String name, String comment, byte[] bb) throws Exception {
        try (ZipInputStream zis = new ZipInputStream(is, cs)) {
            ZipEntry e = zis.getNextEntry();
            if (e == null || !name.equals(e.getName()))
                throw new RuntimeException("ZipIS name doesn't match!");
            byte[] bBuf = new byte[bb.length << 1];
            int n = zis.read(bBuf, 0, bBuf.length);
            if (n != bb.length || !Arrays.equals(bb, Arrays.copyOf(bBuf, n))) {
                throw new RuntimeException("ZipIS content doesn't match!");
            }
        }
        return bb;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16027().testZipInputStream(is, cs, name, comment, bb);
    }
}
