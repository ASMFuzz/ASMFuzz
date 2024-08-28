import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_11353 {

    static Window win = null;

    static boolean activated = false;

    void doActivate() {
        activated = true;
        notify();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11353().doActivate();
    }
}
