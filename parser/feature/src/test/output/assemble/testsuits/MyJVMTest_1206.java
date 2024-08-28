import javax.swing.*;
import java.io.File;
import java.net.URI;

public class MyJVMTest_1206 {

    static String fParam1Param1 = "sC[yW23~C/";

    static String fParam1Param2 = "Kt%hx4{mo$";

    static String fParam1Param3 = "O<Y?b_\"[{3";

    static int fParam1Param4 = 368;

    static String fParam1Param5 = "HebK*1+p3k";

    static String fParam1Param6 = "^f^/3DF%H+";

    static String fParam1Param7 = "(W_3M7GpRx";

    static URI fParam1 = new URI(fParam1Param1, fParam1Param2, fParam1Param3, fParam1Param4, fParam1Param5, fParam1Param6, fParam1Param7);

    static File f = new File(fParam1);

    boolean accept(File f) {
        return f.isDirectory() || f.getName().toLowerCase().endsWith(".xml");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1206().accept(f));
    }
}
