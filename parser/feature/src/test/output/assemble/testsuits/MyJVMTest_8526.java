import java.io.*;
import java.util.*;

public class MyJVMTest_8526 {

    static String fileParam1 = ".qc^KNQPqO";

    static File file = new File(fileParam1);

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
        System.out.println(Arrays.asList(new MyJVMTest_8526().getFileBytes(file)));
    }
}
