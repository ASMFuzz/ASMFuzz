import java.io.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_6336 {

    static byte[] inParam1Param1 = { 66, 118, -104, 108, -4, 80, -24, 40, -21, -26 };

    static InputStream inParam1 = new ByteArrayInputStream(inParam1Param1);

    static Charset inParam2 = null;

    static ZipInputStream in = new ZipInputStream(inParam1, inParam2);

    static OutputStream outParam1 = new ByteArrayOutputStream();

    static ZipOutputStream out = new ZipOutputStream(outParam1);

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
        new MyJVMTest_6336().copyZip(in, out);
    }
}
