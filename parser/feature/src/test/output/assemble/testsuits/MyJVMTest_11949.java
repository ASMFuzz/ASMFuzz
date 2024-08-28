import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_11949 {

    void mouseClick(Robot r, Point p) throws Exception {
        r.mouseMove(p.x, p.y);
        r.mousePress(InputEvent.BUTTON1_MASK);
        r.mouseRelease(InputEvent.BUTTON1_MASK);
        r.waitForIdle();
    }

    static Robot r = null;

    static JFrame frame1 = null;

    static JFrame frame2 = null;

    static JButton bn1 = null;

    static JButton bs1 = null;

    static JButton bn2 = null;

    static JButton bs2 = null;

    static Point bn1Loc = null;

    static Point bs1Loc = null;

    static Point bn2Loc = null;

    static Point bs2Loc = null;

    static boolean unblocked1 = true;

    static boolean unblocked2 = true;

    void start() throws Exception {
        r.setAutoDelay(200);
        unblocked1 = false;
        mouseClick(r, bn1Loc);
        if (!unblocked1) {
            throw new RuntimeException("Test FAILED: frame1 must be unblocked, if no modal internal frames are shown");
        }
        unblocked2 = false;
        mouseClick(r, bn2Loc);
        if (!unblocked2) {
            throw new RuntimeException("Test FAILED: frame2 must be unblocked, if no modal internal frame is shown in it");
        }
        mouseClick(r, bs1Loc);
        unblocked1 = false;
        mouseClick(r, bn1Loc);
        if (unblocked1) {
            throw new RuntimeException("Test FAILED: frame1 must be blocked, if a modal internal frame is shown in it");
        }
        unblocked2 = false;
        mouseClick(r, bn2Loc);
        if (!unblocked2) {
            throw new RuntimeException("Test FAILED: frame2 must be unblocked, if no modal internal frame is shown in it");
        }
        mouseClick(r, bs2Loc);
        unblocked2 = false;
        mouseClick(r, bn2Loc);
        if (unblocked2) {
            throw new RuntimeException("Test FAILED: frame2 must be blocked, if a modal internal frame is shown in it");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11949().start();
    }
}
