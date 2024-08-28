import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_3069 {

    static String eParam1Param1Param1Param1 = "Ny~lyKX9f:";

    static Frame eParam1Param1Param1 = new Frame(eParam1Param1Param1Param1);

    static Window eParam1Param1 = new Window(eParam1Param1Param1);

    static Window eParam1 = new Window(eParam1Param1);

    static int eParam2 = 215;

    static String eParam3Param1Param1Param1Param1 = "B7Q0}>\\i_}";

    static Frame eParam3Param1Param1Param1 = new Frame(eParam3Param1Param1Param1Param1);

    static Window eParam3Param1Param1 = new Window(eParam3Param1Param1Param1);

    static Window eParam3Param1 = new Window(eParam3Param1Param1);

    static GraphicsConfiguration eParam3Param2 = null;

    static Window eParam3 = new Window(eParam3Param1, eParam3Param2);

    static int eParam4 = 878;

    static int eParam5 = 394;

    static WindowEvent e = new WindowEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

    static Object obj = new Object();

    WindowEvent windowClosing(WindowEvent e) {
        e.getWindow().dispose();
        synchronized (obj) {
            obj.notify();
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3069().windowClosing(e);
    }
}
