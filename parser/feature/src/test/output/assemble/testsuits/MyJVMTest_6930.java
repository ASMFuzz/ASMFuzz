import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_6930 {

    static Object aeParam1 = 1;

    static int aeParam2 = 881;

    static String aeParam3 = "_o7TJL04ny";

    static long aeParam4 = -9223372036854775808L;

    static int aeParam5 = 102;

    static ActionEvent ae = new ActionEvent(aeParam1, aeParam2, aeParam3, aeParam4, aeParam5);

    static Robot r = null;

    static JDesktopPane pane2 = null;

    ActionEvent actionPerformed(ActionEvent ae) {
        JOptionPane.showInternalMessageDialog(pane2, "Dialog2");
        return ae;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6930().actionPerformed(ae);
    }
}
