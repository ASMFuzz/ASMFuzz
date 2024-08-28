import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_4096 {

    static Component eParam1 = new Container();

    static int eParam2 = 550;

    static FocusEvent e = new FocusEvent(eParam1, eParam2);

    static Frame f = null;

    static Button b = null;

    static Dialog d = null;

    static boolean gotFocus = false;

    FocusEvent focusGained(FocusEvent e) {
        gotFocus = true;
        System.err.println("Ok got focus");
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4096().focusGained(e);
    }
}
