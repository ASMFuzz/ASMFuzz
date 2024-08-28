import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_2214 {

    static GraphicsConfiguration evParam1Param1Param1Param1Param1 = null;

    static Frame evParam1Param1Param1Param1 = new Frame(evParam1Param1Param1Param1Param1);

    static Window evParam1Param1Param1 = new Window(evParam1Param1Param1Param1);

    static GraphicsConfiguration evParam1Param1Param2 = null;

    static Window evParam1Param1 = new Window(evParam1Param1Param1, evParam1Param1Param2);

    static Window evParam1 = new Window(evParam1Param1);

    static int evParam2 = 752;

    static int evParam3 = 538;

    static int evParam4 = 574;

    static WindowEvent ev = new WindowEvent(evParam1, evParam2, evParam3, evParam4);

    static PrintCanvas canvas = null;

    WindowEvent windowClosing(WindowEvent ev) {
        System.exit(0);
        return ev;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2214().windowClosing(ev);
    }
}
