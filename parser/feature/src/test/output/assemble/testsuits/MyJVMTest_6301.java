import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class MyJVMTest_6301 {

    static ItemSelectable eParam1 = null;

    static int eParam2 = 122;

    static Object eParam3 = 72888011;

    static int eParam4 = 22;

    static ItemEvent e = new ItemEvent(eParam1, eParam2, eParam3, eParam4);

    static boolean passed = false;

    ItemEvent itemStateChanged(ItemEvent e) {
        System.out.println("ItemEvent received.  Test passes");
        passed = true;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6301().itemStateChanged(e);
    }
}
