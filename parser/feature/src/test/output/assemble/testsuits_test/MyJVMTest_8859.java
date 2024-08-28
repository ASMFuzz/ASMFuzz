import javax.swing.*;
import java.awt.*;

public class MyJVMTest_8859 {

    static String s = "HxD=z9-2Wb";

    static String eParam1 = "vHW\"P_nb=[";

    static Throwable eParam2Param1Param1 = new Throwable();

    static Throwable eParam2Param1 = new Throwable(eParam2Param1Param1);

    static Throwable eParam2 = new Throwable(eParam2Param1);

    static boolean eParam3 = true;

    static boolean eParam4 = false;

    static Throwable e = new Throwable(eParam1, eParam2, eParam3, eParam4);

    static String newFolderToolTipText = "uW\\3F+1|BQ";

    static String lookAndFeel = "2Q6;i<X]OJ";

    static Object[][] DIRECTORIES = new Object[][] { { "getDesktop", Boolean.TRUE }, { "getDrives", Boolean.FALSE }, { "getRecent", Boolean.TRUE }, { "getNetwork", Boolean.FALSE }, { "getPersonal", Boolean.TRUE } };

    Throwable fail(String s, Throwable e) {
        throw new RuntimeException("Test failed for LookAndFeel " + lookAndFeel + ": " + s, e);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8859().fail(s, e);
    }
}
