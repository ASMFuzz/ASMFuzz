import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_18160 {

    static int DATA_LEN = 1024 * 1024;

    static int DATA_SIZE = 8;

    static long fileSize = 3L * 1024L * 1024L * 1024L;

    static byte[] data = {-29,92,80,90,5,63,42,48,114,31};

    static File largeFile = null;

    static String lastEntryName = "G!.LBFlxGa";

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
        new MyJVMTest_18160().createLargeZip();
    }
}
