import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_3395 {

    static String eParam1Param1Param1Param1Param1 = "hr$/aidY]a";

    static GraphicsConfiguration eParam1Param1Param1Param1Param2 = null;

    static Frame eParam1Param1Param1Param1 = new Frame(eParam1Param1Param1Param1Param1, eParam1Param1Param1Param1Param2);

    static Window eParam1Param1Param1 = new Window(eParam1Param1Param1Param1);

    static GraphicsConfiguration eParam1Param1Param2 = null;

    static Window eParam1Param1 = new Window(eParam1Param1Param1, eParam1Param1Param2);

    static Window eParam1 = new Window(eParam1Param1);

    static int eParam2 = 995;

    static String eParam3Param1Param1Param1Param1Param1 = "+<Gsy&''8,";

    static Frame eParam3Param1Param1Param1Param1 = new Frame(eParam3Param1Param1Param1Param1Param1);

    static Window eParam3Param1Param1Param1 = new Window(eParam3Param1Param1Param1Param1);

    static Window eParam3Param1Param1 = new Window(eParam3Param1Param1Param1);

    static GraphicsConfiguration eParam3Param1Param2 = null;

    static Window eParam3Param1 = new Window(eParam3Param1Param1, eParam3Param1Param2);

    static GraphicsConfiguration eParam3Param2 = null;

    static Window eParam3 = new Window(eParam3Param1, eParam3Param2);

    static int eParam4 = 921;

    static int eParam5 = 262;

    static WindowEvent e = new WindowEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

    void doOpen() {
        opened = true;
        notify();
    }

    static Window win = null;

    static boolean opened = false;

    WindowEvent windowOpened(WindowEvent e) {
        doOpen();
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3395().windowOpened(e);
    }
}
