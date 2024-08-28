import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_803 {

    static Object eParam1 = 251580158;

    static int eParam2 = 995;

    static String eParam3 = "z6CC >e=AV";

    static long eParam4 = 9223372036854775807L;

    static int eParam5 = 843;

    static AWTEvent e = new ActionEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

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
        new MyJVMTest_803().eventDispatched(e);
    }
}
