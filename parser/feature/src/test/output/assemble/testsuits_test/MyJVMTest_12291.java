import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_12291 {

    static JSpinner spinner1 = null, spinner2 = null;

    void doTest() throws Exception {
        Robot robot = new Robot();
        robot.waitForIdle();
        Point p = spinner2.getLocationOnScreen();
        Rectangle rect = spinner2.getBounds();
        robot.mouseMove(p.x + rect.width - 5, p.y + 5);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        Thread.sleep(1000);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        if (((Integer) spinner2.getValue()).intValue() == 1) {
            throw new Error("Spinner value should be more than 1");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12291().doTest();
    }
}
