import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_1418 {

    static Robot robot = null;

    void init() {
        try {
            robot = new Robot();
            robot.setAutoDelay(50);
        } catch (AWTException e) {
            throw new RuntimeException("Error: unable to create robot", e);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1418().init();
    }
}
