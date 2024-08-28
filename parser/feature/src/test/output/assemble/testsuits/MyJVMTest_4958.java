import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;

public class MyJVMTest_4958 {

    static Robot robot = null;

    void init() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException("Error: couldn't create robot");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4958().init();
    }
}
