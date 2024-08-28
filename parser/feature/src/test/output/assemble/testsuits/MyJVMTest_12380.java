import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_12380 {

    static GraphicsConfiguration eParam1Param1Param1Param1Param1Param1Param1 = null;

    static Frame eParam1Param1Param1Param1Param1Param1 = new Frame(eParam1Param1Param1Param1Param1Param1Param1);

    static Window eParam1Param1Param1Param1Param1 = new Window(eParam1Param1Param1Param1Param1Param1);

    static GraphicsConfiguration eParam1Param1Param1Param1Param2 = null;

    static Window eParam1Param1Param1Param1 = new Window(eParam1Param1Param1Param1Param1, eParam1Param1Param1Param1Param2);

    static GraphicsConfiguration eParam1Param1Param1Param2 = null;

    static Window eParam1Param1Param1 = new Window(eParam1Param1Param1Param1, eParam1Param1Param1Param2);

    static GraphicsConfiguration eParam1Param1Param2 = null;

    static Window eParam1Param1 = new Window(eParam1Param1Param1, eParam1Param1Param2);

    static GraphicsConfiguration eParam1Param2 = null;

    static Window eParam1 = new Window(eParam1Param1, eParam1Param2);

    static int eParam2 = 618;

    static int eParam3 = 867;

    static int eParam4 = 715;

    static WindowEvent e = new WindowEvent(eParam1, eParam2, eParam3, eParam4);

    static Object obj = new Object();

    WindowEvent windowClosing(WindowEvent e) {
        e.getWindow().dispose();
        synchronized (obj) {
            obj.notify();
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12380().windowClosing(e);
    }
}
