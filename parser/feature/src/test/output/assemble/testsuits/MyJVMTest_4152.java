import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_4152 {

    static Robot robot = null;

    static int shift = 834420391;

    void init() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException("Error: unable to create robot", e);
        }
        shift = 100;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4152().init();
    }
}
