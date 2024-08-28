import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_2106 {

    static Window win = null;

    static boolean activated = false;

    void doActivate() {
        activated = true;
        notify();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2106().doActivate();
    }
}
