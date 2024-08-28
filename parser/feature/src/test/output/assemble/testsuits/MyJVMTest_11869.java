import java.awt.event.*;
import java.lang.reflect.*;
import java.awt.*;

public class MyJVMTest_11869 {

    static Component c = new Container();

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

    void run() {
    }

    static Robot robot = null;

    Component clickOn(Component c) {
        Point p = c.getLocationOnScreen();
        Dimension d = c.getSize();
        System.out.println("Clicking " + c);
        robot.mouseMove(p.x + (int) (d.getWidth() / 2), p.y + (int) (d.getHeight() / 2));
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        waitForIdle();
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11869().clickOn(c);
    }
}
