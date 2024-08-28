import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;

public class MyJVMTest_14364 {

    static Robot robot = null;

    void init() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException("Error: couldn't create robot");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14364().init();
    }
}
