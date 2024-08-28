import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_1456 {

    static Component feParam1 = new Container();

    static int feParam2 = 527;

    static FocusEvent fe = new FocusEvent(feParam1, feParam2);

    void raise() {
        state = true;
        if (waiting > 0) {
            notifyAll();
        }
    }

    static Frame f = null;

    static Button b = null;

    static Dialog d = null;

    static boolean state = false;

    static int waiting = 0;

    void makeFocused(Component comp) {
        if (comp.isFocusOwner()) {
            return;
        }
        final Semaphore sema = new Semaphore();
        final FocusAdapter fa = new FocusAdapter() {

            public FocusEvent focusGained(FocusEvent fe) {
                sema.raise();
                return fe;
            }
        };
        comp.addFocusListener(fa);
        comp.requestFocusInWindow();
        if (comp.isFocusOwner()) {
            return;
        }
        try {
            sema.doWait(3000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        comp.removeFocusListener(fa);
        if (!comp.isFocusOwner()) {
            throw new RuntimeException("Can't make " + comp + " focused, current owner is " + KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner());
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1456().focusGained(fe);
    }
}
