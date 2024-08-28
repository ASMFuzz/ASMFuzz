import java.io.*;
import java.nio.charset.*;
import java.util.*;
import java.util.zip.*;
import java.net.URI;

public class MyJVMTest_11474 {

    static String fParam1Param1 = "c~+C.Zps%u";

    static String fParam1Param2 = "3uA==_;lun";

    static String fParam1Param3 = "D1|nw[?e=g";

    static String fParam1Param4 = "M'KIHW4?*|";

    static String fParam1Param5 = "7y*:vpOy@E";

    static URI fParam1 = new URI(fParam1Param1, fParam1Param2, fParam1Param3, fParam1Param4, fParam1Param5);

    static File f = new File(fParam1);

    static Charset cs = null;

    static String name = "Y{L)T$+Lp3";

    static String comment = "i9P4_V7*q8";

    static byte[] bb = { -104, -78, -85, 69, -49, -76, 41, 69, -20, -95 };

    byte[] testZipFile(File f, Charset cs, String name, String comment, byte[] bb) throws Exception {
        try (ZipFile zf = new ZipFile(f, cs)) {
            Enumeration<? extends ZipEntry> zes = zf.entries();
            ZipEntry e = (ZipEntry) zes.nextElement();
            if (!name.equals(e.getName()) || !comment.equals(e.getComment()))
                throw new RuntimeException("ZipFile: name/comment doesn't match!");
            InputStream is = zf.getInputStream(e);
            if (is == null)
                throw new RuntimeException("ZipFile: getIS failed!");
            byte[] bBuf = new byte[bb.length << 1];
            int n = 0;
            int nn = 0;
            while ((nn = is.read(bBuf, n, bBuf.length - n)) != -1) {
                n += nn;
            }
            if (n != bb.length || !Arrays.equals(bb, Arrays.copyOf(bBuf, n))) {
                throw new RuntimeException("ZipFile content doesn't match!");
            }
        }
        return bb;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11474().testZipFile(f, cs, name, comment, bb);
    }
}
