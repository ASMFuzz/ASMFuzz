import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_9982 {

    static Object eParam1 = 1230754039;

    static int eParam2 = 268;

    static String eParam3 = "koaerTo_%2";

    static int eParam4 = 997;

    static AWTEvent e = new ActionEvent(eParam1, eParam2, eParam3, eParam4);

    static Frame f = null;

    static Button b = null;

    static Dialog d = null;

    static int deliver_count = 0;

    AWTEvent eventDispatched(AWTEvent e) {
        if (e instanceof KeyEvent) {
            deliver_count++;
            System.err.println("key_event# " + deliver_count);
        }
        if (e instanceof InputEvent) {
            System.err.println(e.toString() + "," + ((InputEvent) e).getWhen());
        } else {
            System.err.println(e.toString());
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9982().eventDispatched(e);
    }
}
