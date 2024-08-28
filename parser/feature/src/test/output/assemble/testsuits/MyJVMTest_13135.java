import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;

public class MyJVMTest_13135 {

    static String filename = "mYG/qsHCAq";

    String printFile(String filename) throws Exception {
        File file = new File(filename);
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        String s = "";
        for (int i = 0; i < data.length; i++) {
            s += String.valueOf(data[i]) + ", ";
            if (s.length() > 72) {
                System.out.println(s);
                s = "";
            }
        }
        System.out.println(s);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13135().printFile(filename);
    }
}
