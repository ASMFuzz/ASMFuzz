import java.io.*;
import java.util.zip.*;

public class MyJVMTest_16018 {

    static String zipFileParam1 = ",bM/!t6\"UO";

    static File zipFile = new File(zipFileParam1);

    int entryCount(File zipFile) throws IOException {
        try (FileInputStream fis = new FileInputStream(zipFile);
            ZipInputStream zis = new ZipInputStream(fis)) {
            for (int count = 0; ; count++) if (zis.getNextEntry() == null)
                return count;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16018().entryCount(zipFile));
    }
}
