import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_13654 {

    static Object eParam1 = 0;

    static int eParam2 = 657;

    static String eParam3 = "\"Ss|`}1:Rr";

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3);

    ActionEvent actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Pass")) {
            System.exit(0);
        } else {
            System.exit(-1);
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13654().actionPerformed(e);
    }
}
