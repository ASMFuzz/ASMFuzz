import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_16756 {

    static Robot robot = null;

    void init() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException("Error: unable to create robot", e);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16756().init();
    }
}
