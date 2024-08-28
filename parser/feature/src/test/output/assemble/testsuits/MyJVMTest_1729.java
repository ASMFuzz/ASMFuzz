import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_1729 {

    static Frame f = null;

    static Button b = null;

    static Dialog d = null;

    static boolean state = false;

    static int waiting = 0;

    void doWait() throws InterruptedException {
        if (state) {
            return;
        }
        waiting++;
        wait();
        waiting--;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1729().doWait();
    }
}
