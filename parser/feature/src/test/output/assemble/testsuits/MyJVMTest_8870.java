import javax.swing.*;
import java.awt.*;

public class MyJVMTest_8870 {

    static String s = "d6y?!ya?t)";

    static String newFolderToolTipText = "Lrbp&5w4-l";

    static String lookAndFeel = "N-,\"<T$6q,";

    static Object[][] DIRECTORIES = new Object[][] { { "getDesktop", Boolean.TRUE }, { "getDrives", Boolean.FALSE }, { "getRecent", Boolean.TRUE }, { "getNetwork", Boolean.FALSE }, { "getPersonal", Boolean.TRUE } };

    String fail(String s) {
        throw new RuntimeException("Test failed: " + s);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8870().fail(s);
    }
}
