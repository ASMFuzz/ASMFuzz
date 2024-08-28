import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_11467 {

    static GraphicsConfiguration evParam1Param1Param1Param1Param1Param1 = null;

    static Frame evParam1Param1Param1Param1Param1 = new Frame(evParam1Param1Param1Param1Param1Param1);

    static Window evParam1Param1Param1Param1 = new Window(evParam1Param1Param1Param1Param1);

    static Window evParam1Param1Param1 = new Window(evParam1Param1Param1Param1);

    static Window evParam1Param1 = new Window(evParam1Param1Param1);

    static GraphicsConfiguration evParam1Param2 = null;

    static Window evParam1 = new Window(evParam1Param1, evParam1Param2);

    static int evParam2 = 187;

    static GraphicsConfiguration evParam3Param1Param1Param1 = null;

    static Frame evParam3Param1Param1 = new Frame(evParam3Param1Param1Param1);

    static Window evParam3Param1 = new Window(evParam3Param1Param1);

    static GraphicsConfiguration evParam3Param2 = null;

    static Window evParam3 = new Window(evParam3Param1, evParam3Param2);

    static int evParam4 = 454;

    static int evParam5 = 736;

    static WindowEvent ev = new WindowEvent(evParam1, evParam2, evParam3, evParam4, evParam5);

    static PrintCanvas canvas = null;

    WindowEvent windowClosing(WindowEvent ev) {
        System.exit(0);
        return ev;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11467().windowClosing(ev);
    }
}
