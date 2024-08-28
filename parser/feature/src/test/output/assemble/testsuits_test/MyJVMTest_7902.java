import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_7902 {

    static String eParam1Param1Param1Param1Param1 = "[W.IQiK%cD";

    static GraphicsConfiguration eParam1Param1Param1Param1Param2 = null;

    static Frame eParam1Param1Param1Param1 = new Frame(eParam1Param1Param1Param1Param1, eParam1Param1Param1Param1Param2);

    static Window eParam1Param1Param1 = new Window(eParam1Param1Param1Param1);

    static GraphicsConfiguration eParam1Param1Param2 = null;

    static Window eParam1Param1 = new Window(eParam1Param1Param1, eParam1Param1Param2);

    static GraphicsConfiguration eParam1Param2 = null;

    static Window eParam1 = new Window(eParam1Param1, eParam1Param2);

    static int eParam2 = 473;

    static int eParam3 = 862;

    static int eParam4 = 761;

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
        new MyJVMTest_7902().windowActivated(e);
    }
}
