import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class MyJVMTest_9187 {

    static Robot robot = new Robot();

    static Point p = new Point();

    static Component comp = new Container();

    void reset() {
        clickedComponent = null;
    }

    static Object SYNC_LOCK = new Object();

    static int MOUSE_RELEASE_TIMEOUT = 1000;

    static Component clickedComponent = null;

    boolean pointInComponent(Robot robot, Point p, Component comp) throws InterruptedException {
        robot.waitForIdle();
        reset();
        robot.mouseMove(p.x, p.y);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        synchronized (SYNC_LOCK) {
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            SYNC_LOCK.wait(MOUSE_RELEASE_TIMEOUT);
        }
        Component c = clickedComponent;
        while (c != null && c != comp) {
            c = c.getParent();
        }
        return c == comp;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9187().pointInComponent(robot, p, comp));
    }
}
