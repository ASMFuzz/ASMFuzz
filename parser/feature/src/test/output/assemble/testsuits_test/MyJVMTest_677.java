import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_677 {

    static Robot robot = new Robot();

    Robot pressAltF4Keys(Robot robot) {
        if (robot != null) {
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_F4);
            robot.delay(50);
            robot.keyRelease(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_ALT);
        }
        return robot;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_677().pressAltF4Keys(robot);
    }
}
