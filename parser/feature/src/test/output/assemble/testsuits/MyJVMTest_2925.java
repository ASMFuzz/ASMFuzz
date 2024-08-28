import java.io.File;
import java.io.FileOutputStream;

public class MyJVMTest_2925 {

    static String fosParam1 = "838m>Mv/x9";

    static boolean fosParam2 = false;

    static FileOutputStream fos = new FileOutputStream(fosParam1, fosParam2);

    static String s = "zV}tfD!NZ{";

    FileOutputStream output(FileOutputStream fos, String s) throws Exception {
        fos.write(s.getBytes("UTF8"));
        fos.write("\n".getBytes("UTF8"));
        return fos;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2925().output(fos, s);
    }
}
