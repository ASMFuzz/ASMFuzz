import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_6368 {

    static GraphicsDevice robotParam1 = null;

    static Robot robot = new Robot(robotParam1);

    static int keys = 2;

    int hitKeys(Robot robot, int... keys) {
        for (int i = 0; i < keys.length; i++) {
            robot.keyPress(keys[i]);
        }
        for (int i = keys.length - 1; i >= 0; i--) {
            robot.keyRelease(keys[i]);
        }
        return keys;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6368().hitKeys(robot, keys);
    }
}
