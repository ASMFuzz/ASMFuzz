import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_9933 {

    static GraphicsConfiguration eParam1Param1Param1Param1Param1Param1Param1Param1Param1Param1Param1Param1 = null;

    static Frame eParam1Param1Param1Param1Param1Param1Param1Param1Param1Param1Param1 = new Frame(eParam1Param1Param1Param1Param1Param1Param1Param1Param1Param1Param1Param1);

    static Window eParam1Param1Param1Param1Param1Param1Param1Param1Param1Param1 = new Window(eParam1Param1Param1Param1Param1Param1Param1Param1Param1Param1Param1);

    static GraphicsConfiguration eParam1Param1Param1Param1Param1Param1Param1Param1Param1Param2 = null;

    static Window eParam1Param1Param1Param1Param1Param1Param1Param1Param1 = new Window(eParam1Param1Param1Param1Param1Param1Param1Param1Param1Param1, eParam1Param1Param1Param1Param1Param1Param1Param1Param1Param2);

    static GraphicsConfiguration eParam1Param1Param1Param1Param1Param1Param1Param1Param2 = null;

    static Window eParam1Param1Param1Param1Param1Param1Param1Param1 = new Window(eParam1Param1Param1Param1Param1Param1Param1Param1Param1, eParam1Param1Param1Param1Param1Param1Param1Param1Param2);

    static GraphicsConfiguration eParam1Param1Param1Param1Param1Param1Param1Param2 = null;

    static Window eParam1Param1Param1Param1Param1Param1Param1 = new Window(eParam1Param1Param1Param1Param1Param1Param1Param1, eParam1Param1Param1Param1Param1Param1Param1Param2);

    static Window eParam1Param1Param1Param1Param1Param1 = new Window(eParam1Param1Param1Param1Param1Param1Param1);

    static Window eParam1Param1Param1Param1Param1 = new Window(eParam1Param1Param1Param1Param1Param1);

    static GraphicsConfiguration eParam1Param1Param1Param1Param2 = null;

    static Window eParam1Param1Param1Param1 = new Window(eParam1Param1Param1Param1Param1, eParam1Param1Param1Param1Param2);

    static GraphicsConfiguration eParam1Param1Param1Param2 = null;

    static Window eParam1Param1Param1 = new Window(eParam1Param1Param1Param1, eParam1Param1Param1Param2);

    static GraphicsConfiguration eParam1Param1Param2 = null;

    static Window eParam1Param1 = new Window(eParam1Param1Param1, eParam1Param1Param2);

    static GraphicsConfiguration eParam1Param2 = null;

    static Window eParam1 = new Window(eParam1Param1, eParam1Param2);

    static int eParam2 = 42;

    static int eParam3 = 874;

    static int eParam4 = 223;

    static WindowEvent e = new WindowEvent(eParam1, eParam2, eParam3, eParam4);

    static Object showLock = new Object();

    static int counter = 9;

    WindowEvent windowOpened(WindowEvent e) {
        synchronized (showLock) {
            showLock.notify();
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9933().windowOpened(e);
    }
}
