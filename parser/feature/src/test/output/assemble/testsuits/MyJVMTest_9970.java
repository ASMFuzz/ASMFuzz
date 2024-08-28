import java.io.*;
import java.util.Arrays;

public class MyJVMTest_9970 {

    static String name = "\">:S`_\"7ox";

    byte[] getClassData(String name) {
        try {
            String TempName = name.replaceAll("\\.", "/");
            String currentDir = System.getProperty("test.classes");
            String filename = currentDir + File.separator + TempName + ".class";
            FileInputStream fis = new FileInputStream(filename);
            byte[] b = new byte[5000];
            int cnt = fis.read(b, 0, 5000);
            byte[] c = new byte[cnt];
            for (int i = 0; i < cnt; i++) c[i] = b[i];
            return c;
        } catch (IOException e) {
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_9970().getClassData(name)));
    }
}
