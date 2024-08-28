import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_7382 {

    static String eParam1Param1Param1Param1Param1Param1Param1Param1 = "]gZT:};zp.";

    static Frame eParam1Param1Param1Param1Param1Param1Param1 = new Frame(eParam1Param1Param1Param1Param1Param1Param1Param1);

    static Window eParam1Param1Param1Param1Param1Param1 = new Window(eParam1Param1Param1Param1Param1Param1Param1);

    static GraphicsConfiguration eParam1Param1Param1Param1Param1Param2 = null;

    static Window eParam1Param1Param1Param1Param1 = new Window(eParam1Param1Param1Param1Param1Param1, eParam1Param1Param1Param1Param1Param2);

    static GraphicsConfiguration eParam1Param1Param1Param1Param2 = null;

    static Window eParam1Param1Param1Param1 = new Window(eParam1Param1Param1Param1Param1, eParam1Param1Param1Param1Param2);

    static GraphicsConfiguration eParam1Param1Param1Param2 = null;

    static Window eParam1Param1Param1 = new Window(eParam1Param1Param1Param1, eParam1Param1Param1Param2);

    static Window eParam1Param1 = new Window(eParam1Param1Param1);

    static GraphicsConfiguration eParam1Param2 = null;

    static Window eParam1 = new Window(eParam1Param1, eParam1Param2);

    static int eParam2 = 767;

    static GraphicsConfiguration eParam3Param1Param1 = null;

    static Frame eParam3Param1 = new Frame(eParam3Param1Param1);

    static Window eParam3 = new Window(eParam3Param1);

    static int eParam4 = 114;

    static int eParam5 = 519;

    static WindowEvent e = new WindowEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

    WindowEvent windowClosing(WindowEvent e) {
        e.getWindow().dispose();
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7382().windowClosing(e);
    }
}
