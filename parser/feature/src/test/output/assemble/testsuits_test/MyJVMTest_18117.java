import java.io.*;
import java.util.*;

public class MyJVMTest_18117 {

    static String fileParam1Param1 = "Egkklst#r.";

    static File fileParam1 = new File(fileParam1Param1);

    static String fileParam2 = "/b7`iYK~lw";

    static File file = new File(fileParam1, fileParam2);

    byte[] getFileBytes(File file) throws IOException {
        FileInputStream fin = new FileInputStream(file);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        byte[] buf = new byte[256];
        int n;
        while ((n = fin.read(buf)) != -1) {
            bout.write(buf, 0, n);
        }
        fin.close();
        return bout.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_18117().getFileBytes(file)));
    }
}
