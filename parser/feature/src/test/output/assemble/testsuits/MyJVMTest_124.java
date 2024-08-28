import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class MyJVMTest_124 {

    static Robot robot = new Robot();

    static int k = 6;

    static double yCaret = Double.MAX_VALUE;

    static double xCaret = Double.NaN;

    static JEditorPane edit = new JEditorPane();

    Robot hitKey(Robot robot, int k) throws Exception {
        robot.delay(50);
        robot.keyPress(k);
        robot.keyRelease(k);
        robot.delay(50);
        return robot;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_124().hitKey(robot, k);
    }
}
