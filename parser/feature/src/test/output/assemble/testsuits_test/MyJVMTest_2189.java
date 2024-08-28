import java.io.*;
import java.net.URI;

public class MyJVMTest_2189 {

    static String dirParam1Param1 = ";1IQHnVXMY";

    static String dirParam1Param2 = "VN$f%\"*t^=";

    static String dirParam1Param3 = "w!kjd\"ovb.";

    static int dirParam1Param4 = 736;

    static String dirParam1Param5 = "7_52Ahesr?";

    static String dirParam1Param6 = "^R&paB:ei1";

    static String dirParam1Param7 = "Jm1'yfh>T~";

    static URI dirParam1 = new URI(dirParam1Param1, dirParam1Param2, dirParam1Param3, dirParam1Param4, dirParam1Param5, dirParam1Param6, dirParam1Param7);

    static File dir = new File(dirParam1);

    static String name = "}srcQp}Jnm";

    boolean accept(File dir, String name) {
        if (name.endsWith(".java"))
            return false;
        if (name.indexOf("CVS") != -1)
            return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2189().accept(dir, name));
    }
}
