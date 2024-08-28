import java.io.File;

public class MyJVMTest_11141 {

    static String dirParam1 = "=80O{4JZJA";

    static String dirParam2 = "Vh?=yLdl%:";

    static File dir = new File(dirParam1, dirParam2);

    void clean(File file) {
        if (!file.exists())
            return;
        if (file.isDirectory()) {
            for (File f : file.listFiles()) clean(f);
        }
        file.delete();
    }

    File mkCleanDir(File dir) {
        clean(dir);
        dir.mkdirs();
        return dir;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11141().mkCleanDir(dir);
    }
}
