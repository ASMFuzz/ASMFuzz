import java.awt.event.*;
import java.lang.reflect.*;
import java.awt.*;

public class MyJVMTest_17738 {

    static Component eParam1 = new Container();

    static int eParam2 = 949;

    static FocusEvent e = new FocusEvent(eParam1, eParam2);

    static boolean focusGained = false;

    static Object monitor = new Object();

    FocusEvent focusGained(FocusEvent e) {
        System.out.println(e.toString());
        synchronized (monitor) {
            focusGained = true;
            monitor.notifyAll();
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17738().focusGained(e);
    }
}
