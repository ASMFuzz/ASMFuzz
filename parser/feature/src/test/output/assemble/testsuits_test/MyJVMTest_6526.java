import java.io.*;
import java.util.zip.*;

public class MyJVMTest_6526 {

    static String zipFileParam1Param1 = "RUPZLbpXs,";

    static String zipFileParam1Param2 = "rsQgYiN:Kx";

    static File zipFileParam1 = new File(zipFileParam1Param1, zipFileParam1Param2);

    static String zipFileParam2 = " ;,}0K8:YW";

    static File zipFile = new File(zipFileParam1, zipFileParam2);

    int entryCount(File zipFile) throws IOException {
        try (FileInputStream fis = new FileInputStream(zipFile);
            ZipInputStream zis = new ZipInputStream(fis)) {
            for (int count = 0; ; count++) if (zis.getNextEntry() == null)
                return count;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6526().entryCount(zipFile));
    }
}
