import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class MyJVMTest_9270 {

    static GraphicsDevice robotParam1 = null;

    static Robot robot = new Robot(robotParam1);

    static int k = 0;

    static double yCaret = 0.5570908868860033;

    static double xCaret = Double.NEGATIVE_INFINITY;

    static JEditorPane edit = new JEditorPane();

    Robot hitKey(Robot robot, int k) throws Exception {
        robot.delay(50);
        robot.keyPress(k);
        robot.keyRelease(k);
        robot.delay(50);
        return robot;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9270().hitKey(robot, k);
    }
}
