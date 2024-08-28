import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_681 {

    static Object eParam1 = 2;

    static int eParam2 = 393;

    static String eParam3 = "bgX ){PGAn";

    static int eParam4 = 804;

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3, eParam4);

    static JTabbedPane tabPane = null;

    static JPanel mainPanel = null;

    static int placement = 1;

    static boolean a = true;

    ActionEvent actionPerformed(ActionEvent e) {
        for (int i = 0; i < tabPane.getTabCount(); i++) {
            System.out.println("Tab: " + i + " " + tabPane.getUI().getTabBounds(tabPane, i));
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_681().actionPerformed(e);
    }
}
