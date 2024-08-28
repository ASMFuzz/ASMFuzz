import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.nio.file.spi.*;
import java.util.*;
import java.util.zip.*;
import static java.nio.file.StandardCopyOption.*;

public class MyJVMTest_4292 {

    static int DATA_LEN = 80 * 1024;

    static int DATA_SIZE = 8;

    static long fileSize = 6L * 1024L * 1024L * 1024L;

    static byte[] data = {-109,-112,-83,73,31,15,20,19,117,63};

    static File largeFile = null;

    static String lastEntryName = "NmhU8<rRgF";

    void createLargeZip() throws Throwable {
        int iterations = DATA_LEN / DATA_SIZE;
        ByteBuffer bb = ByteBuffer.allocate(DATA_SIZE);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for (int i = 0; i < iterations; i++) {
            bb.putDouble(0, Math.random());
            baos.write(bb.array(), 0, DATA_SIZE);
        }
        data = baos.toByteArray();
        try (FileOutputStream fos = new FileOutputStream(largeFile);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ZipOutputStream zos = new ZipOutputStream(bos)) {
            long length = 0;
            while (length < fileSize) {
                ZipEntry ze = new ZipEntry("entry-" + length);
                lastEntryName = ze.getName();
                zos.putNextEntry(ze);
                zos.write(data, 0, data.length);
                zos.closeEntry();
                length = largeFile.length();
            }
            System.out.println("Last entry written is " + lastEntryName);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4292().createLargeZip();
    }
}
