import java.awt.*;
import java.awt.print.*;
import java.awt.event.*;

public class MyJVMTest_955 {

    static GraphicsConfiguration evParam1Param1Param1Param1Param1Param1Param1 = null;

    static Frame evParam1Param1Param1Param1Param1Param1 = new Frame(evParam1Param1Param1Param1Param1Param1Param1);

    static Window evParam1Param1Param1Param1Param1 = new Window(evParam1Param1Param1Param1Param1Param1);

    static GraphicsConfiguration evParam1Param1Param1Param1Param2 = null;

    static Window evParam1Param1Param1Param1 = new Window(evParam1Param1Param1Param1Param1, evParam1Param1Param1Param1Param2);

    static GraphicsConfiguration evParam1Param1Param1Param2 = null;

    static Window evParam1Param1Param1 = new Window(evParam1Param1Param1Param1, evParam1Param1Param1Param2);

    static GraphicsConfiguration evParam1Param1Param2 = null;

    static Window evParam1Param1 = new Window(evParam1Param1Param1, evParam1Param1Param2);

    static GraphicsConfiguration evParam1Param2 = null;

    static Window evParam1 = new Window(evParam1Param1, evParam1Param2);

    static int evParam2 = 657;

    static GraphicsConfiguration evParam3Param1Param1 = null;

    static Frame evParam3Param1 = new Frame(evParam3Param1Param1);

    static Window evParam3 = new Window(evParam3Param1);

    static int evParam4 = 105;

    static int evParam5 = 445;

    static WindowEvent ev = new WindowEvent(evParam1, evParam2, evParam3, evParam4, evParam5);

    WindowEvent windowClosed(WindowEvent ev) {
        System.exit(0);
        return ev;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_955().windowClosed(ev);
    }
}
