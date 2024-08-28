import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import java.applet.Applet;

public class MyJVMTest_16220 {

    static Component c = new Container();

    void waitForIdle() {
        try {
            robot.waitForIdle();
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
        robot.delay(200);
    }

    void run() {
    }

    static Robot robot = null;

    Component clickOn(Component c) {
        Point p = c.getLocationOnScreen();
        Dimension d = c.getSize();
        System.out.println("Clicking " + c);
        if (c instanceof Frame) {
            robot.mouseMove(p.x + (int) (d.getWidth() / 2), p.y + ((Frame) c).getInsets().top / 2);
        } else {
            robot.mouseMove(p.x + (int) (d.getWidth() / 2), p.y + (int) (d.getHeight() / 2));
        }
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        waitForIdle();
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16220().clickOn(c);
    }
}
