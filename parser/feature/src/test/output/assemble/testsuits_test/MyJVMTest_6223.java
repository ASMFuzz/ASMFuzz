import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_6223 {

    static Object eParam1 = 7;

    static int eParam2 = 481;

    static String eParam3 = "wJ@|2#`ey:";

    static int eParam4 = 954;

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3, eParam4);

    static JTabbedPane tabPane = null;

    static JPanel mainPanel = null;

    static int placement = 0;

    static boolean a = true;

    ActionEvent actionPerformed(ActionEvent e) {
        if (a) {
            tabPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
            a = false;
        } else {
            tabPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
            a = true;
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6223().actionPerformed(e);
    }
}
