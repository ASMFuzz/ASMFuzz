import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyJVMTest_2328 {

    static String eParam1Param1Param1Param1Param1 = "cc9|~anJ66";

    static GraphicsConfiguration eParam1Param1Param1Param1Param2 = null;

    static Frame eParam1Param1Param1Param1 = new Frame(eParam1Param1Param1Param1Param1, eParam1Param1Param1Param1Param2);

    static Window eParam1Param1Param1 = new Window(eParam1Param1Param1Param1);

    static Window eParam1Param1 = new Window(eParam1Param1Param1);

    static GraphicsConfiguration eParam1Param2 = null;

    static Window eParam1 = new Window(eParam1Param1, eParam1Param2);

    static int eParam2 = 470;

    static WindowEvent e = new WindowEvent(eParam1, eParam2);

    void this_windowClosing(WindowEvent e) {
        System.exit(0);
    }

    static int n = 0;

    WindowEvent windowClosing(WindowEvent e) {
        this_windowClosing(e);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2328().windowClosing(e);
    }
}
