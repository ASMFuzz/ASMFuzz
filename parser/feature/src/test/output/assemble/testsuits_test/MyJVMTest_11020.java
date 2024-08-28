import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_11020 {

    static GraphicsDevice robotParam1 = null;

    static Robot robot = new Robot(robotParam1);

    Robot clickOnFrame(Robot robot) {
        Frame frame = new Frame();
        frame.setBounds(100, 100, 100, 100);
        frame.setVisible(true);
        robot.waitForIdle();
        robot.mouseMove(150, 150);
        robot.delay(50);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(50);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.waitForIdle();
        return robot;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11020().clickOnFrame(robot);
    }
}
