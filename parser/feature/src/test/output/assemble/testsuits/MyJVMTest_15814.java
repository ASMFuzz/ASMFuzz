import java.io.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_15814 {

    static byte[] inParam1Param1 = { -58, -12, -126, -65, -5, -122, -62, -104, 68, -126 };

    static int inParam1Param2 = 831;

    static int inParam1Param3 = 74;

    static InputStream inParam1 = new ByteArrayInputStream(inParam1Param1, inParam1Param2, inParam1Param3);

    static Charset inParam2 = null;

    static ZipInputStream in = new ZipInputStream(inParam1, inParam2);

    static OutputStream outParam1 = new ByteArrayOutputStream();

    static Charset outParam2 = null;

    static ZipOutputStream out = new ZipOutputStream(outParam1, outParam2);

    ZipInputStream copyZip(ZipInputStream in, ZipOutputStream out) throws IOException {
        byte[] buffer = new byte[1 << 14];
        for (ZipEntry ze; (ze = in.getNextEntry()) != null; ) {
            out.putNextEntry(ze);
            for (int nr; 0 < (nr = in.read(buffer)); ) {
                out.write(buffer, 0, nr);
            }
        }
        in.close();
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15814().copyZip(in, out);
    }
}
