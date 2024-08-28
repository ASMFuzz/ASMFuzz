import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import static java.awt.font.TextAttribute.*;

public class MyJVMTest_12648 {

    static GraphicsConfiguration eParam1Param1Param1Param1Param1 = null;

    static Frame eParam1Param1Param1Param1 = new Frame(eParam1Param1Param1Param1Param1);

    static Window eParam1Param1Param1 = new Window(eParam1Param1Param1Param1);

    static Window eParam1Param1 = new Window(eParam1Param1Param1);

    static GraphicsConfiguration eParam1Param2 = null;

    static Window eParam1 = new Window(eParam1Param1, eParam1Param2);

    static int eParam2 = 654;

    static GraphicsConfiguration eParam3Param1Param1Param1Param1 = null;

    static Frame eParam3Param1Param1Param1 = new Frame(eParam3Param1Param1Param1Param1);

    static Window eParam3Param1Param1 = new Window(eParam3Param1Param1Param1);

    static Window eParam3Param1 = new Window(eParam3Param1Param1);

    static Window eParam3 = new Window(eParam3Param1);

    static WindowEvent e = new WindowEvent(eParam1, eParam2, eParam3);

    static DrawStrSuper dss = null;

    WindowEvent windowClosing(WindowEvent e) {
        System.exit(0);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12648().windowClosing(e);
    }
}
