import java.io.File;
import java.io.FileOutputStream;
import java.io.FileDescriptor;

public class MyJVMTest_12225 {

    static FileDescriptor fosParam1 = new FileDescriptor();

    static FileOutputStream fos = new FileOutputStream(fosParam1);

    static String s = "@sl5x{y2u'";

    FileOutputStream output(FileOutputStream fos, String s) throws Exception {
        fos.write(s.getBytes("UTF8"));
        fos.write("\n".getBytes("UTF8"));
        return fos;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12225().output(fos, s);
    }
}
