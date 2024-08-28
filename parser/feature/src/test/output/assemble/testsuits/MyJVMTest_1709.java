import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_1709 {

    static String eParam1Param1Param1 = "8w>ja2X3eI";

    static GraphicsConfiguration eParam1Param1Param2 = null;

    static Frame eParam1Param1 = new Frame(eParam1Param1Param1, eParam1Param1Param2);

    static Window eParam1 = new Window(eParam1Param1);

    static int eParam2 = 990;

    static String eParam3Param1Param1 = "O#_@$aLL=%";

    static GraphicsConfiguration eParam3Param1Param2 = null;

    static Frame eParam3Param1 = new Frame(eParam3Param1Param1, eParam3Param1Param2);

    static Window eParam3 = new Window(eParam3Param1);

    static WindowEvent e = new WindowEvent(eParam1, eParam2, eParam3);

    void doGainedFocus() {
        focused = true;
        notify();
    }

    static Window win = null;

    static boolean focused = false;

    WindowEvent windowGainedFocus(WindowEvent e) {
        doGainedFocus();
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1709().windowGainedFocus(e);
    }
}
