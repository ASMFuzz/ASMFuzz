import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_13513 {

    static Robot robot = null;

    static int shift = 1560480699;

    void init() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException("Error: unable to create robot", e);
        }
        shift = 100;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13513().init();
    }
}
