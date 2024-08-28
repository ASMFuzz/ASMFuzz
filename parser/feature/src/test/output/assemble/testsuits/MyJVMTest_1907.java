import java.io.File;
import java.net.URI;

public class MyJVMTest_1907 {

    static String dirParam1Param1 = "r~XU+T/n2D";

    static String dirParam1Param2 = "L$v7cp[J*{";

    static String dirParam1Param3 = "xbDnAPP}^W";

    static int dirParam1Param4 = 584;

    static String dirParam1Param5 = "?5%r=;v;/=";

    static String dirParam1Param6 = "j:P]8<e\"A5";

    static String dirParam1Param7 = "S]U b&hw@L";

    static URI dirParam1 = new URI(dirParam1Param1, dirParam1Param2, dirParam1Param3, dirParam1Param4, dirParam1Param5, dirParam1Param6, dirParam1Param7);

    static File dir = new File(dirParam1);

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
        new MyJVMTest_1907().mkCleanDir(dir);
    }
}
