import java.io.File;
import javax.swing.JApplet;

public class MyJVMTest_8944 {

    static String dirParam1Param1 = "J!-S^wcD11";

    static File dirParam1 = new File(dirParam1Param1);

    static String dirParam2 = "'ZGUA(G2wU";

    static File dir = new File(dirParam1, dirParam2);

    boolean isRoot(File dir) {
        return bug6698013.root.equals(dir);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8944().isRoot(dir));
    }
}
