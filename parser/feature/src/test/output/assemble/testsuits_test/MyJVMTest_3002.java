import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_3002 {

    static String evParam1Param1Param1Param1 = "4)PZ#Q`qGv";

    static GraphicsConfiguration evParam1Param1Param1Param2 = null;

    static Frame evParam1Param1Param1 = new Frame(evParam1Param1Param1Param1, evParam1Param1Param1Param2);

    static Window evParam1Param1 = new Window(evParam1Param1Param1);

    static GraphicsConfiguration evParam1Param2 = null;

    static Window evParam1 = new Window(evParam1Param1, evParam1Param2);

    static int evParam2 = 461;

    static String evParam3Param1Param1Param1Param1 = "J9iO#lxw2]";

    static GraphicsConfiguration evParam3Param1Param1Param1Param2 = null;

    static Frame evParam3Param1Param1Param1 = new Frame(evParam3Param1Param1Param1Param1, evParam3Param1Param1Param1Param2);

    static Window evParam3Param1Param1 = new Window(evParam3Param1Param1Param1);

    static GraphicsConfiguration evParam3Param1Param2 = null;

    static Window evParam3Param1 = new Window(evParam3Param1Param1, evParam3Param1Param2);

    static Window evParam3 = new Window(evParam3Param1);

    static int evParam4 = 540;

    static int evParam5 = 295;

    static WindowEvent ev = new WindowEvent(evParam1, evParam2, evParam3, evParam4, evParam5);

    WindowEvent windowClosing(WindowEvent ev) {
        System.exit(0);
        return ev;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3002().windowClosing(ev);
    }
}
