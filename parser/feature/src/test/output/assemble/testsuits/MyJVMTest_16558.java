import java.awt.event.*;
import java.lang.reflect.*;
import java.awt.*;

public class MyJVMTest_16558 {

    static Component c = new Container();

    void clickOn(Component c) {
        Point p = c.getLocationOnScreen();
        Dimension d = c.getSize();
        System.out.println("Clicking " + c);
        if (c instanceof Frame) {
            robot.mouseMove(p.x + (int) (d.getWidth() / 2), p.y + ((Frame) c).getInsets().top / 2);
        } else {
            robot.mouseMove(p.x + (int) (d.getWidth() / 2), p.y + (int) (d.getHeight() / 2));
        }
        robot.delay(50);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(50);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.waitForIdle();
    }

    boolean checkFocusOwner(Component comp) {
        return (comp == KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner());
    }

    static Robot robot = null;

    Component clickOnCheckFocusOwner(Component c) {
        clickOn(c);
        if (!checkFocusOwner(c)) {
            throw new RuntimeException("Test failed: couldn't focus <" + c + "> by mouse click!");
        }
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16558().clickOnCheckFocusOwner(c);
    }
}
