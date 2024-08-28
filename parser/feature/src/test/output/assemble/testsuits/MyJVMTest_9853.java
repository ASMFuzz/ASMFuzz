import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_9853 {

    static Object eParam1 = 8;

    static int eParam2 = 638;

    static String eParam3 = "#{Qnrj{G@7";

    static int eParam4 = 647;

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3, eParam4);

    static JTabbedPane tabPane = null;

    static JPanel mainPanel = null;

    static int placement = -1024424172;

    static boolean a = true;

    ActionEvent actionPerformed(ActionEvent e) {
        for (int i = 0; i < tabPane.getTabCount(); i++) {
            System.out.println("Tab: " + i + " " + tabPane.getUI().getTabBounds(tabPane, i));
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9853().actionPerformed(e);
    }
}
