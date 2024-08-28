import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_755 {

    static String eParam1Param1Param1 = "|3~P.3IS1)";

    static GraphicsConfiguration eParam1Param1Param2 = null;

    static Frame eParam1Param1 = new Frame(eParam1Param1Param1, eParam1Param1Param2);

    static Window eParam1 = new Window(eParam1Param1);

    static int eParam2 = 285;

    static int eParam3 = 179;

    static int eParam4 = 578;

    static WindowEvent e = new WindowEvent(eParam1, eParam2, eParam3, eParam4);

    static Object showLock = new Object();

    static int counter = 0;

    WindowEvent windowOpened(WindowEvent e) {
        synchronized (showLock) {
            showLock.notify();
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_755().windowOpened(e);
    }
}
