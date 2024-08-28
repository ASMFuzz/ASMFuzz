import java.io.*;
import java.util.zip.*;

public class MyJVMTest_15227 {

    static String dirParam1Param1 = "64$?pviA9F";

    static File dirParam1 = new File(dirParam1Param1);

    static String dirParam2 = "vRK?Bn+T~1";

    static File dir = new File(dirParam1, dirParam2);

    static String zipFileParam1 = "e(p{zE=E.x";

    static File zipFile = new File(zipFileParam1);

    File zip(File dir, File zipFile) throws IOException {
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                byte[] data = new byte[(int) file.length()];
                DataInputStream in = new DataInputStream(new FileInputStream(file));
                in.readFully(data);
                in.close();
                zipOut.putNextEntry(new ZipEntry(file.getName()));
                zipOut.write(data, 0, data.length);
                zipOut.closeEntry();
            }
        }
        zipOut.close();
        return zipFile;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15227().zip(dir, zipFile));
    }
}
