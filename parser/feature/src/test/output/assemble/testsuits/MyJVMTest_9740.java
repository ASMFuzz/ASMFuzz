import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_9740 {

    static Object eParam1 = 2;

    static int eParam2 = 934;

    static String eParam3 = ")X2^uZ;8aa";

    static int eParam4 = 119;

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3, eParam4);

    static JFrame frame = null;

    static JDialog dialog = null;

    ActionEvent actionPerformed(ActionEvent e) {
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9740().actionPerformed(e);
    }
}
