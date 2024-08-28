import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class MyJVMTest_387 {

    static ItemSelectable eParam1 = null;

    static int eParam2 = 636;

    static Object eParam3 = -2124263070;

    static int eParam4 = 221;

    static ItemEvent e = new ItemEvent(eParam1, eParam2, eParam3, eParam4);

    static boolean passed = false;

    ItemEvent itemStateChanged(ItemEvent e) {
        Sysout.println("ItemEvent received.  Test passes");
        passed = true;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_387().itemStateChanged(e);
    }
}
