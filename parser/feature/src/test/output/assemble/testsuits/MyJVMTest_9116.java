import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_9116 {

    static Object evtParam1 = 0;

    static int evtParam2 = 965;

    static String evtParam3 = " q_p\")#hT7";

    static long evtParam4 = 9223372036854775807L;

    static int evtParam5 = 508;

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
        new MyJVMTest_9116().actionPerformed(evt);
    }
}
