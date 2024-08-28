import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_16440 {

    static Object aeParam1 = 8;

    static int aeParam2 = 754;

    static String aeParam3 = "GFqYw,aM9{";

    static long aeParam4 = -9223372036854775808L;

    static int aeParam5 = 77;

    static ActionEvent ae = new ActionEvent(aeParam1, aeParam2, aeParam3, aeParam4, aeParam5);

    static Robot r = null;

    static JDesktopPane pane2 = null;

    ActionEvent actionPerformed(ActionEvent ae) {
        JOptionPane.showInternalMessageDialog(pane2, "Dialog2");
        return ae;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16440().actionPerformed(ae);
    }
}
