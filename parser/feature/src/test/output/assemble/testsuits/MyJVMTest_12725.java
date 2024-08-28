import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_12725 {

    static String eParam1Param1Param1Param1 = "K_fRnO;qg-";

    static Frame eParam1Param1Param1 = new Frame(eParam1Param1Param1Param1);

    static Window eParam1Param1 = new Window(eParam1Param1Param1);

    static Window eParam1 = new Window(eParam1Param1);

    static int eParam2 = 45;

    static String eParam3Param1Param1Param1Param1 = "\\Ipe.{DHY]";

    static GraphicsConfiguration eParam3Param1Param1Param1Param2 = null;

    static Frame eParam3Param1Param1Param1 = new Frame(eParam3Param1Param1Param1Param1, eParam3Param1Param1Param1Param2);

    static Window eParam3Param1Param1 = new Window(eParam3Param1Param1Param1);

    static Window eParam3Param1 = new Window(eParam3Param1Param1);

    static GraphicsConfiguration eParam3Param2 = null;

    static Window eParam3 = new Window(eParam3Param1, eParam3Param2);

    static WindowEvent e = new WindowEvent(eParam1, eParam2, eParam3);

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
        new MyJVMTest_12725().windowOpened(e);
    }
}
