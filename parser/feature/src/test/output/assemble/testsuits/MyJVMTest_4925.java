import javax.swing.*;
import java.awt.*;

public class MyJVMTest_4925 {

    static Robot robot = null;

    void initRobot() throws AWTException {
        robot = new Robot();
        robot.setAutoDelay(100);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4925().initRobot();
    }
}
