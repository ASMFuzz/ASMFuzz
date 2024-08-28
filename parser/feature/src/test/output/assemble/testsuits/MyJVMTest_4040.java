import javax.swing.*;
import java.awt.*;

public class MyJVMTest_4040 {

    static String s = "qW37r3mT$w";

    static String newFolderToolTipText = "e213Ia@WY-";

    static String lookAndFeel = ":F)s=^[>W<";

    static Object[][] DIRECTORIES = new Object[][] { { "getDesktop", Boolean.TRUE }, { "getDrives", Boolean.FALSE }, { "getRecent", Boolean.TRUE }, { "getNetwork", Boolean.FALSE }, { "getPersonal", Boolean.TRUE } };

    String fail(String s) {
        throw new RuntimeException("Test failed: " + s);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4040().fail(s);
    }
}
