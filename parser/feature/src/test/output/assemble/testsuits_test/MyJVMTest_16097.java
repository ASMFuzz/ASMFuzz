import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_16097 {

    static Object evtParam1 = -128253855;

    static int evtParam2 = 6;

    static String evtParam3 = "~LrN[4.'A%";

    static long evtParam4 = 0;

    static int evtParam5 = 963;

    static ActionEvent evt = new ActionEvent(evtParam1, evtParam2, evtParam3, evtParam4, evtParam5);

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
        new MyJVMTest_16097().actionPerformed(evt);
    }
}
