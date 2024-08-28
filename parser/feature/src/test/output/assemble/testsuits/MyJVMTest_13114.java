import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_13114 {

    static Object eParam1 = 0;

    static int eParam2 = 320;

    static String eParam3 = "wEfFNJT#/W";

    static int eParam4 = 659;

    static AWTEvent e = new ActionEvent(eParam1, eParam2, eParam3, eParam4);

    static Frame f = null;

    static Button b = null;

    static Dialog d = null;

    AWTEvent eventDispatched(AWTEvent e) {
        if (e instanceof InputEvent) {
            System.err.println(e.toString() + "," + ((InputEvent) e).getWhen());
        } else {
            System.err.println(e.toString());
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13114().eventDispatched(e);
    }
}
