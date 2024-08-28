import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_10572 {

    static Object aeParam1 = 5;

    static int aeParam2 = 422;

    static String aeParam3 = "9*&VY>15$u";

    static int aeParam4 = 432;

    static ActionEvent ae = new ActionEvent(aeParam1, aeParam2, aeParam3, aeParam4);

    static Robot r = null;

    static JDesktopPane pane1 = null;

    ActionEvent actionPerformed(ActionEvent ae) {
        JOptionPane.showInternalMessageDialog(pane1, "Dialog1");
        return ae;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10572().actionPerformed(ae);
    }
}
