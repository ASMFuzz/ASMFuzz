import java.io.File;
import java.util.concurrent.CountDownLatch;

public class MyJVMTest_5413 {

    static String fileParam1Param1Param1 = "}'y:[NBt0_";

    static String fileParam1Param1Param2 = "W3Pv<!pcz1";

    static File fileParam1Param1 = new File(fileParam1Param1Param1, fileParam1Param1Param2);

    static String fileParam1Param2 = "vVCq-qv8C`";

    static File fileParam1 = new File(fileParam1Param1, fileParam1Param2);

    static String fileParam2 = "B]fHL$Us4H";

    static File file = new File(fileParam1, fileParam2);

    boolean accept(File file) {
        return !file.isFile() || file.getName().toLowerCase().endsWith(".txt");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5413().accept(file));
    }
}
