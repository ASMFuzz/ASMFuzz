import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class MyJVMTest_6779 {

    static Object lock = new Object();

    void run() {
        try {
            Thread.sleep(10000);
            synchronized (lock) {
                System.err.println("passed");
                System.exit(0);
            }
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6779().run();
    }
}
