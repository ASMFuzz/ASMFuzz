import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_1363 {

    static Object aeParam1 = 8;

    static int aeParam2 = 54;

    static String aeParam3 = "~!\"C^a?|Id";

    static long aeParam4 = 0;

    static int aeParam5 = 149;

    static ActionEvent ae = new ActionEvent(aeParam1, aeParam2, aeParam3, aeParam4, aeParam5);

    static Robot r = null;

    static JDesktopPane pane1 = null;

    ActionEvent actionPerformed(ActionEvent ae) {
        JOptionPane.showInternalMessageDialog(pane1, "Dialog1");
        return ae;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1363().actionPerformed(ae);
    }
}
