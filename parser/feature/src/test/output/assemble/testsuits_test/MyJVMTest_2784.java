import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_2784 {

    static int key = -403926762;

    static Robot robot = new Robot();

    static int delay = 500;

    static int keyDelay = 50;

    Robot keyType(int key, Robot robot) throws Exception {
        robot.keyPress(key);
        robot.delay(keyDelay);
        robot.keyRelease(key);
        robot.delay(keyDelay);
        return robot;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2784().keyType(key, robot);
    }
}
