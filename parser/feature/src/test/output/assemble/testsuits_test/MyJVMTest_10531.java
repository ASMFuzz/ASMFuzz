import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_10531 {

    static Object eParam1 = 0;

    static int eParam2 = 308;

    static String eParam3 = "3 HwX%gbb>";

    static int eParam4 = 987;

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3, eParam4);

    static JTabbedPane tabPane = null;

    static JPanel mainPanel = null;

    static int placement = -1798193714;

    static boolean a = true;

    ActionEvent actionPerformed(ActionEvent e) {
        tabPane.setTabPlacement(placement);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10531().actionPerformed(e);
    }
}
