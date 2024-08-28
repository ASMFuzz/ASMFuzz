import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_15696 {

    static Object eParam1 = 0;

    static int eParam2 = 489;

    static String eParam3 = "H,F8TW1Nj.";

    static long eParam4 = -2911506971595149382L;

    static int eParam5 = 349;

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

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
        new MyJVMTest_15696().actionPerformed(e);
    }
}
