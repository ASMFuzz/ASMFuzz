import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_9556 {

    static Frame testframe = new Frame();

    static String msg = "NQG% [J((&";

    void requireVisible() {
        int tries = 0;
        try {
            while ((opened == false) || (activated == false) || (focused == false)) {
                if (tries < 4) {
                    tries += 1;
                    wait(SETUP_PERIOD);
                } else {
                    break;
                }
            }
            if (opened && activated) {
                valid = true;
            } else {
                valid = false;
            }
        } catch (InterruptedException ix) {
            valid = false;
        }
        if (win.isVisible() == false) {
            valid = false;
        }
        if (win.isShowing() == false) {
            valid = false;
        }
        if (win.isFocused() == false) {
            valid = false;
        }
        if (DEBUG) {
            if (!isValid()) {
                System.out.println("\tactivated:" + new Boolean(activated));
                System.out.println("\topened:" + new Boolean(opened));
                System.out.println("\tfocused:" + new Boolean(focused));
                System.out.println("\tvalid:" + new Boolean(valid));
                System.out.println("\tisVisible():" + new Boolean(win.isVisible()));
                System.out.println("\tisShowing():" + new Boolean(win.isShowing()));
                System.out.println("\tisFocused():" + new Boolean(win.isFocused()));
            }
        }
    }

    boolean isValid() {
        return valid;
    }

    static int SETUP_PERIOD = 5000;

    static boolean DEBUG = false;

    static Window win = null;

    static boolean activated = false;

    static boolean opened = false;

    static boolean focused = false;

    static boolean valid = false;

    Frame setVisibleAndConfirm(Frame testframe, String msg) throws Exception {
        if (testframe.isVisible()) {
            throw new RuntimeException("Frame is already visible");
        }
        VisibilityValidator checkpoint = new VisibilityValidator(testframe);
        testframe.setVisible(true);
        checkpoint.requireVisible();
        if (!checkpoint.isValid()) {
            throw new Exception("Frame not visible after " + SETUP_PERIOD + " milliseconds");
        }
        return testframe;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9556().setVisibleAndConfirm(testframe, msg);
    }
}
