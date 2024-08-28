import java.nio.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.zip.*;
import java.io.*;

public class MyJVMTest_16958 {

    static int zosParam1Param1 = 67;

    static OutputStream zosParam1 = new ByteArrayOutputStream(zosParam1Param1);

    static ZipOutputStream zos = new ZipOutputStream(zosParam1);

    static CRC32 crc = new CRC32();

    static String zeParam1 = "KyRMlB,/a5";

    static ZipEntry ze = new ZipEntry(zeParam1);

    static int method = 0;

    static int szMax = -374831797;

    static Random r = new Random();

    static int N = 50;

    static Set<Path> paths = new HashSet<>();

    static String name = "m0v|'ZXe3Z";

    static Map<ZipEntry, byte[]> entries = new HashMap<ZipEntry,byte[]>();

    static BasicFileAttributes attrs = null;

    static long lastModified = 9223372036854775807L;

    ZipEntry writeEntry(ZipOutputStream zos, CRC32 crc, ZipEntry ze, int method, int szMax) throws IOException {
        ze.setMethod(method);
        byte[] data = new byte[r.nextInt(szMax + 1)];
        r.nextBytes(data);
        if (method == ZipEntry.STORED) {
            ze.setSize(data.length);
            ze.setCompressedSize(data.length);
            crc.reset();
            crc.update(data);
            ze.setCrc(crc.getValue());
        }
        ze.setTime(System.currentTimeMillis());
        ze.setComment(ze.getName());
        zos.putNextEntry(ze);
        zos.write(data);
        zos.closeEntry();
        entries.put(ze, data);
        return ze;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16958().writeEntry(zos, crc, ze, method, szMax);
    }
}
