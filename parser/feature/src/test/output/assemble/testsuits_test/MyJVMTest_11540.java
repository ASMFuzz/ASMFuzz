import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_11540 {

    static JFrame frame = new JFrame();

    static Robot robot = null;

    JFrame clickWindowsTitle(JFrame frame) {
        Point point = frame.getLocationOnScreen();
        robot.mouseMove(point.x + (frame.getWidth() / 2), point.y + frame.getInsets().top / 2);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        return frame;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11540().clickWindowsTitle(frame);
    }
}
