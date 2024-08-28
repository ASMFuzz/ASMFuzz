import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;

public class MyJVMTest_3794 {

    static String filename = "zmi8|i;o`2";

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
        new MyJVMTest_3794().printFile(filename);
    }
}
