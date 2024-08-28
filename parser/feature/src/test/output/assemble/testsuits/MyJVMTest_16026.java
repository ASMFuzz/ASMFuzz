import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_16026 {

    static Frame f = null;

    static Button b = null;

    static Dialog d = null;

    static boolean state = false;

    static int waiting = 0;

    void raise() {
        state = true;
        if (waiting > 0) {
            notifyAll();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16026().raise();
    }
}
