import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class MyJVMTest_5638 {

    static String name = "SDINv^M?fR";

    byte[] getClassData(String name) {
        try {
            String TempName = name.replaceAll("\\.", "/");
            String currentDir = System.getProperty("test.classes");
            String filename = currentDir + File.separator + TempName + ".class";
            System.out.println("filename is " + filename);
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
        System.out.println(Arrays.asList(new MyJVMTest_5638().getClassData(name)));
    }
}
