import java.io.File;
import java.util.concurrent.CountDownLatch;

public class MyJVMTest_14839 {

    static String fileParam1 = "CDC*l7w:=(";

    static String fileParam2 = "wIw,ZB5Z3+";

    static File file = new File(fileParam1, fileParam2);

    boolean accept(File file) {
        return !file.isFile() || file.getName().toLowerCase().endsWith(".txt");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14839().accept(file));
    }
}
