import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class MyJVMTest_7385 {

    static Object lock = new Object();

    void start() {
        Thread thread = new Thread(new Runnable() {

            public void run() {
                try {
                    Thread.sleep(10000);
                    synchronized (lock) {
                        System.err.println("passed");
                        System.exit(0);
                    }
                } catch (InterruptedException e) {
                }
            }
        });
        thread.start();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7385().run();
    }
}
