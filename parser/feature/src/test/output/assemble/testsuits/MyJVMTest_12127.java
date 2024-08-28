import java.io.*;
import java.util.*;
import java.util.zip.*;
import javax.tools.*;

public class MyJVMTest_12127 {

    static String zipParam1 = ")-bWM9}WN}";

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
        new MyJVMTest_12127().createTestZip(zip, paths);
    }
}
