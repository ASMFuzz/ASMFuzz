import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class MyJVMTest_9544 {

    static ItemSelectable eParam1 = null;

    static int eParam2 = 546;

    static Object eParam3 = 8;

    static int eParam4 = 18;

    static ItemEvent e = new ItemEvent(eParam1, eParam2, eParam3, eParam4);

    static boolean passed = false;

    ItemEvent itemStateChanged(ItemEvent e) {
        Sysout.println("ItemEvent received.  Test passes");
        passed = true;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9544().itemStateChanged(e);
    }
}
