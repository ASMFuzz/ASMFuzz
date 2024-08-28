import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_11832 {

    static int timeout = 2;

    static Frame f = null;

    static Button b = null;

    static Dialog d = null;

    static boolean state = false;

    static int waiting = 0;

    int doWait(int timeout) throws InterruptedException {
        if (state) {
            return;
        }
        waiting++;
        wait(timeout);
        waiting--;
        return timeout;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11832().doWait(timeout);
    }
}
