import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_17834 {

    static Frame evParam1Param1Param1 = new Frame();

    static Window evParam1Param1 = new Window(evParam1Param1Param1);

    static GraphicsConfiguration evParam1Param2 = null;

    static Window evParam1 = new Window(evParam1Param1, evParam1Param2);

    static int evParam2 = 172;

    static WindowEvent ev = new WindowEvent(evParam1, evParam2);

    static int counter = -2144336834;

    WindowEvent windowClosing(WindowEvent ev) {
        System.exit(0);
        return ev;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17834().windowClosing(ev);
    }
}
