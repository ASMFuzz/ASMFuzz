import java.io.*;
import java.util.zip.*;
import java.net.URI;

public class MyJVMTest_9024 {

    static String dirParam1Param1 = "j>0:0\"2Q38";

    static URI dirParam1 = new URI(dirParam1Param1);

    static File dir = new File(dirParam1);

    static String zipFileParam1Param1 = "LiT$?]m7'H";

    static File zipFileParam1 = new File(zipFileParam1Param1);

    static String zipFileParam2 = "$wF[F]#zN-";

    static File zipFile = new File(zipFileParam1, zipFileParam2);

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
        System.out.println(new MyJVMTest_9024().zip(dir, zipFile));
    }
}
