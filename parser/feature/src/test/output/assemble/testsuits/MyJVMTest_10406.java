import javax.swing.*;
import java.io.File;
import java.net.URI;

public class MyJVMTest_10406 {

    static String fParam1Param1Param1 = "K~Xx?tR^k_";

    static String fParam1Param1Param2 = "#e<%j v+Of";

    static String fParam1Param1Param3 = "f3^ vC2]hp";

    static URI fParam1Param1 = new URI(fParam1Param1Param1, fParam1Param1Param2, fParam1Param1Param3);

    static File fParam1 = new File(fParam1Param1);

    static String fParam2 = "O`}a5ySpKZ";

    static File f = new File(fParam1, fParam2);

    boolean accept(File f) {
        return f.isDirectory() || f.getName().toLowerCase().endsWith(".xml");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10406().accept(f));
    }
}
