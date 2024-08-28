import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_17464 {

    static GraphicsConfiguration eParam1Param1Param1 = null;

    static Frame eParam1Param1 = new Frame(eParam1Param1Param1);

    static Window eParam1 = new Window(eParam1Param1);

    static int eParam2 = 173;

    static int eParam3 = 27;

    static int eParam4 = 876;

    static WindowEvent e = new WindowEvent(eParam1, eParam2, eParam3, eParam4);

    void doActivate() {
        activated = true;
        notify();
    }

    static Window win = null;

    static boolean activated = false;

    WindowEvent windowActivated(WindowEvent e) {
        doActivate();
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17464().windowActivated(e);
    }
}
