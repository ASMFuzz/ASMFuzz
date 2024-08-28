import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_10931 {

    static Frame eParam1Param1 = new Frame();

    static Window eParam1 = new Window(eParam1Param1);

    static int eParam2 = 458;

    static int eParam3 = 757;

    static int eParam4 = 452;

    static WindowEvent e = new WindowEvent(eParam1, eParam2, eParam3, eParam4);

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
        new MyJVMTest_10931().windowGainedFocus(e);
    }
}
