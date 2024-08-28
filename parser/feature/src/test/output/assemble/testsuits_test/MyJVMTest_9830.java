import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class MyJVMTest_9830 {

    static int keycode = -124942515;

    static Robot robot = null;

    Robot hitKey(Robot robot, int keycode) {
        robot.keyPress(keycode);
        robot.keyRelease(keycode);
        robot.waitForIdle();
        return robot;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9830().hitKey(robot, keycode);
    }
}
