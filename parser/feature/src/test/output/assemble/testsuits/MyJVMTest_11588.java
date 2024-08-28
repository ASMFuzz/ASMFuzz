import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyJVMTest_11588 {

    static Frame eParam1Param1Param1Param1Param1Param1Param1 = new Frame();

    static Window eParam1Param1Param1Param1Param1Param1 = new Window(eParam1Param1Param1Param1Param1Param1Param1);

    static Window eParam1Param1Param1Param1Param1 = new Window(eParam1Param1Param1Param1Param1Param1);

    static GraphicsConfiguration eParam1Param1Param1Param1Param2 = null;

    static Window eParam1Param1Param1Param1 = new Window(eParam1Param1Param1Param1Param1, eParam1Param1Param1Param1Param2);

    static Window eParam1Param1Param1 = new Window(eParam1Param1Param1Param1);

    static Window eParam1Param1 = new Window(eParam1Param1Param1);

    static Window eParam1 = new Window(eParam1Param1);

    static int eParam2 = 758;

    static int eParam3 = 339;

    static int eParam4 = 675;

    static WindowEvent e = new WindowEvent(eParam1, eParam2, eParam3, eParam4);

    void this_windowClosing(WindowEvent e) {
        System.exit(0);
    }

    static int n = 0;

    WindowEvent windowClosing(WindowEvent e) {
        this_windowClosing(e);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11588().windowClosing(e);
    }
}
