import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_8258 {

    static Frame evParam1Param1Param1Param1Param1Param1 = new Frame();

    static Window evParam1Param1Param1Param1Param1 = new Window(evParam1Param1Param1Param1Param1Param1);

    static Window evParam1Param1Param1Param1 = new Window(evParam1Param1Param1Param1Param1);

    static Window evParam1Param1Param1 = new Window(evParam1Param1Param1Param1);

    static GraphicsConfiguration evParam1Param1Param2 = null;

    static Window evParam1Param1 = new Window(evParam1Param1Param1, evParam1Param1Param2);

    static GraphicsConfiguration evParam1Param2 = null;

    static Window evParam1 = new Window(evParam1Param1, evParam1Param2);

    static int evParam2 = 627;

    static Frame evParam3Param1Param1Param1Param1Param1Param1 = new Frame();

    static Window evParam3Param1Param1Param1Param1Param1 = new Window(evParam3Param1Param1Param1Param1Param1Param1);

    static Window evParam3Param1Param1Param1Param1 = new Window(evParam3Param1Param1Param1Param1Param1);

    static Window evParam3Param1Param1Param1 = new Window(evParam3Param1Param1Param1Param1);

    static GraphicsConfiguration evParam3Param1Param1Param2 = null;

    static Window evParam3Param1Param1 = new Window(evParam3Param1Param1Param1, evParam3Param1Param1Param2);

    static Window evParam3Param1 = new Window(evParam3Param1Param1);

    static Window evParam3 = new Window(evParam3Param1);

    static int evParam4 = 898;

    static int evParam5 = 903;

    static WindowEvent ev = new WindowEvent(evParam1, evParam2, evParam3, evParam4, evParam5);

    static int counter = 0;

    WindowEvent windowClosing(WindowEvent ev) {
        System.exit(0);
        return ev;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8258().windowClosing(ev);
    }
}
