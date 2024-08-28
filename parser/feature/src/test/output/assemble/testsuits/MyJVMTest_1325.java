import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_1325 {

    static Object eParam1 = 0;

    static int eParam2 = 507;

    static String eParam3 = "0o\\4pb\\x<t";

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3);

    static JTabbedPane tabPane = null;

    static JPanel mainPanel = null;

    static int placement = 9;

    static boolean a = true;

    ActionEvent actionPerformed(ActionEvent e) {
        tabPane.setTabPlacement(placement);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1325().actionPerformed(e);
    }
}
