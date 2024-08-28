import java.io.*;
import java.util.*;
import java.util.zip.*;
import javax.tools.*;
import java.net.URI;

public class MyJVMTest_2831 {

    static String zipParam1Param1 = "OG#P>WGTi*";

    static String zipParam1Param2 = "Hl6BhzSd (";

    static String zipParam1Param3 = "6{(n9/|w[g";

    static URI zipParam1 = new URI(zipParam1Param1, zipParam1Param2, zipParam1Param3);

    static File zip = new File(zipParam1);

    static File file = null;

    static String[] paths = { "p/A.java", "p/B.java", "p/C.java" };

    File createTestZip(File zip, String[] paths) throws IOException {
        if (zip.getParentFile() != null)
            zip.getParentFile().mkdirs();
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zip))) {
            for (String p : paths) {
                ZipEntry ze = new ZipEntry(p);
                zos.putNextEntry(ze);
                byte[] bytes = p.getBytes();
                zos.write(bytes, 0, bytes.length);
                zos.closeEntry();
            }
        }
        return zip;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2831().createTestZip(zip, paths);
    }
}
