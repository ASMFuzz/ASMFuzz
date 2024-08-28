import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class MyJVMTest_15779 {

    static ItemSelectable eParam1 = null;

    static int eParam2 = 98;

    static Object eParam3 = 0;

    static int eParam4 = 619;

    static ItemEvent e = new ItemEvent(eParam1, eParam2, eParam3, eParam4);

    static boolean passed = false;

    ItemEvent itemStateChanged(ItemEvent e) {
        System.out.println("ItemEvent received.  Test passes");
        passed = true;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15779().itemStateChanged(e);
    }
}
