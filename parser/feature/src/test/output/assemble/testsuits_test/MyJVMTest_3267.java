import java.awt.event.*;
import java.lang.reflect.*;
import java.awt.*;

public class MyJVMTest_3267 {

    static Component eParam1 = new Container();

    static int eParam2 = 171;

    static boolean eParam3 = false;

    static Component eParam4 = new Container();

    static FocusEvent e = new FocusEvent(eParam1, eParam2, eParam3, eParam4);

    static boolean focusGained = false;

    static Object monitor = new Object();

    FocusEvent focusGained(FocusEvent e) {
        Sysout.println(e.toString());
        synchronized (monitor) {
            focusGained = true;
            monitor.notifyAll();
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3267().focusGained(e);
    }
}
