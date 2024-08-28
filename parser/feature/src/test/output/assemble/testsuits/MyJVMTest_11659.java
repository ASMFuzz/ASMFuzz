import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_11659 {

    static Component eParam1 = new Container();

    static int eParam2 = 283;

    static boolean eParam3 = false;

    static FocusEvent e = new FocusEvent(eParam1, eParam2, eParam3);

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
        new MyJVMTest_11659().focusGained(e);
    }
}
