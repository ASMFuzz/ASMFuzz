import java.awt.event.*;
import java.lang.reflect.*;
import java.awt.*;

public class MyJVMTest_11435 {

    static Robot robot = null;

    void waitForIdle() {
        try {
            robot.waitForIdle();
            robot.delay(50);
            EventQueue.invokeAndWait(new Runnable() {

                public void run() {
                }
            });
        } catch (InterruptedException ie) {
            System.out.println("waitForIdle, non-fatal exception caught:");
            ie.printStackTrace();
        } catch (InvocationTargetException ite) {
            System.out.println("waitForIdle, non-fatal exception caught:");
            ite.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11435().run();
    }
}
