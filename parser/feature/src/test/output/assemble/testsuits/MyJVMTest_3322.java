import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import static java.awt.font.TextAttribute.*;

public class MyJVMTest_3322 {

    static GraphicsConfiguration eParam1Param1Param1Param1 = null;

    static Frame eParam1Param1Param1 = new Frame(eParam1Param1Param1Param1);

    static Window eParam1Param1 = new Window(eParam1Param1Param1);

    static Window eParam1 = new Window(eParam1Param1);

    static int eParam2 = 585;

    static int eParam3 = 531;

    static int eParam4 = 288;

    static WindowEvent e = new WindowEvent(eParam1, eParam2, eParam3, eParam4);

    static DrawStrSuper dss = null;

    WindowEvent windowClosing(WindowEvent e) {
        System.exit(0);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3322().windowClosing(e);
    }
}
