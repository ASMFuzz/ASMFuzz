import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_2395 {

    static Component eParam1 = new Container();

    static int eParam2 = 356;

    static boolean eParam3 = false;

    static Component eParam4 = new Container();

    static FocusEvent e = new FocusEvent(eParam1, eParam2, eParam3, eParam4);

    static Frame f = null;

    static Button b = null;

    static Dialog d = null;

    static boolean gotFocus = false;

    FocusEvent focusGained(FocusEvent e) {
        gotFocus = true;
        System.err.println("OK got focus");
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2395().focusGained(e);
    }
}
