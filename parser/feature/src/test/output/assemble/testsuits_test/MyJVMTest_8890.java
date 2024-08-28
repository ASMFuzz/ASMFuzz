import java.io.File;
import javax.swing.JApplet;
import java.util.Arrays;

public class MyJVMTest_8890 {

    static String dirParam1 = "8VM?*XDgl0";

    static File dir = new File(dirParam1);

    static boolean hide_hidden = false;

    File[] getFiles(File dir, boolean hide_hidden) {
        if (dir.equals(bug6698013.root)) {
            return new File[] { bug6698013.rootFile, bug6698013.subdir };
        }
        if (dir.equals(bug6698013.subdir)) {
            return new File[] { bug6698013.subdirFile };
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_8890().getFiles(dir, hide_hidden)));
    }
}
