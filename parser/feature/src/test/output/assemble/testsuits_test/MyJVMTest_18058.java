import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import java.applet.Applet;

public class MyJVMTest_18058 {

    static Robot robot = null;

    void waitForIdle() {
        try {
            robot.waitForIdle();
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
        robot.delay(200);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18058().run();
    }
}
