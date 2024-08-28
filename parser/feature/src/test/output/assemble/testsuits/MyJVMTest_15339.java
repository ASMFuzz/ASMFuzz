import java.awt.event.*;
import java.lang.reflect.*;
import java.awt.*;

public class MyJVMTest_15339 {

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
            Sysout.println("waitForIdle, non-fatal exception caught:");
            ie.printStackTrace();
        } catch (InvocationTargetException ite) {
            Sysout.println("waitForIdle, non-fatal exception caught:");
            ite.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15339().run();
    }
}
