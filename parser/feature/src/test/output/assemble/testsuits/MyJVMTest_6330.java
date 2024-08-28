import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_6330 {

    static Component eParam1 = new Container();

    static int eParam2 = 944;

    static boolean eParam3 = true;

    static Component eParam4 = new Container();

    static FocusEvent e = new FocusEvent(eParam1, eParam2, eParam3, eParam4);

    static Button button1 = new Button("Button1");

    static Object lock = new Object();

    FocusEvent focusGained(FocusEvent e) {
        if (e.getSource() == button1) {
            synchronized (lock) {
                throw new RuntimeException("failed: focus on the wrong button");
            }
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6330().focusGained(e);
    }
}
