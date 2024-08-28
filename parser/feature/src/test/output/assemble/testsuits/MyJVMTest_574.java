import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_574 {

    static Object eParam1 = 8;

    static int eParam2 = 669;

    static String eParam3 = "lbRR&3#}CX";

    static int eParam4 = 892;

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3, eParam4);

    static JFrame frame = null;

    static JDialog dialog = null;

    ActionEvent actionPerformed(ActionEvent e) {
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_574().actionPerformed(e);
    }
}
