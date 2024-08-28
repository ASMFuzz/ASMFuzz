import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_4284 {

    static Object eParam1 = 0;

    static int eParam2 = 673;

    static String eParam3 = "6*4iiAy$'G";

    static long eParam4 = -6474722729992451882L;

    static int eParam5 = 541;

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

    ActionEvent actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Pass")) {
            System.exit(0);
        } else {
            System.exit(-1);
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4284().actionPerformed(e);
    }
}
