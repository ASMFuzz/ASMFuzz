import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_11945 {

    static Window win = null;

    static boolean focused = false;

    void doGainedFocus() {
        focused = true;
        notify();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11945().doGainedFocus();
    }
}
