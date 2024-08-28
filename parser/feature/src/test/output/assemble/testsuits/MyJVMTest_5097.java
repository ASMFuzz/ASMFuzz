import javax.swing.*;
import java.awt.*;

public class MyJVMTest_5097 {

    static String s = ";+j\"bjPc._";

    static Throwable e = new Throwable();

    static String newFolderToolTipText = "6$g% \"iL` ";

    static String lookAndFeel = "l`>\"Ybj\\D~";

    static Object[][] DIRECTORIES = new Object[][] { { "getDesktop", Boolean.TRUE }, { "getDrives", Boolean.FALSE }, { "getRecent", Boolean.TRUE }, { "getNetwork", Boolean.FALSE }, { "getPersonal", Boolean.TRUE } };

    Throwable fail(String s, Throwable e) {
        throw new RuntimeException("Test failed for LookAndFeel " + lookAndFeel + ": " + s, e);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5097().fail(s, e);
    }
}
