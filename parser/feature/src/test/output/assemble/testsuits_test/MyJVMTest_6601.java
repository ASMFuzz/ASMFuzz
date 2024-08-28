import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_6601 {

    static Object evtParam1 = 0;

    static int evtParam2 = 659;

    static String evtParam3 = "tz(QL1<pPd";

    static int evtParam4 = 477;

    static ActionEvent evt = new ActionEvent(evtParam1, evtParam2, evtParam3, evtParam4);

    static boolean defaultButtonPressed = false;

    static boolean editChanged = false;

    static JComboBox combo = null;

    String actionPerformed(ActionEvent evt) {
        String cmd = evt.getActionCommand();
        System.out.println("ActionEvent: " + cmd);
        if (cmd.equals("OK")) {
            defaultButtonPressed = true;
        }
        if (cmd.equals("comboBoxChanged")) {
            editChanged = true;
        }
        return cmd;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6601().actionPerformed(evt);
    }
}
