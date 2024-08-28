import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class MyJVMTest_660 {

    static int keycode = 0;

    static Robot robot = null;

    Robot hitKey(Robot robot, int keycode) {
        robot.keyPress(keycode);
        robot.keyRelease(keycode);
        robot.waitForIdle();
        return robot;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_660().hitKey(robot, keycode);
    }
}
