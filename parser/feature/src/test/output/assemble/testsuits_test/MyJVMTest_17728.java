import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class MyJVMTest_17728 {

    static Component eParam1 = new Container();

    static int eParam2 = 277;

    static FocusEvent e = new FocusEvent(eParam1, eParam2);

    static Button button1 = new Button("Button1");

    static Object lock = new Object();

    FocusEvent focusGained(FocusEvent e) {
        if (e.getSource() == button1) {
            synchronized (lock) {
                System.err.println("failed: focus on the wrong button");
                System.exit(2);
            }
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17728().focusGained(e);
    }
}
