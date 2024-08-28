import javax.swing.*;
import java.awt.*;

public class MyJVMTest_13394 {

    static String s = "Sr)U?n*U\\r";

    static String newFolderToolTipText = "qV(U4d8T_:";

    static String lookAndFeel = "@C0mgi!f:)";

    static Object[][] DIRECTORIES = new Object[][] { { "getDesktop", Boolean.TRUE }, { "getDrives", Boolean.FALSE }, { "getRecent", Boolean.TRUE }, { "getNetwork", Boolean.FALSE }, { "getPersonal", Boolean.TRUE } };

    String fail(String s) {
        throw new RuntimeException("Test failed: " + s);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13394().fail(s);
    }
}
