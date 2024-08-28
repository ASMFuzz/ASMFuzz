import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_16971 {

    static int pParam1 = 442;

    static int pParam2 = 256;

    static Point p = new Point(pParam1, pParam2);

    static Robot r = null;

    Robot mouseClick(Robot r, Point p) throws Exception {
        r.mouseMove(p.x, p.y);
        r.mousePress(InputEvent.BUTTON1_MASK);
        r.mouseRelease(InputEvent.BUTTON1_MASK);
        r.waitForIdle();
        return r;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16971().mouseClick(r, p);
    }
}
