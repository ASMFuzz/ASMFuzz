import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class MyJVMTest_10652 {

    static int keycode = 1782678114;

    static Robot robot = null;

    int hitKey(int keycode) {
        robot.keyPress(keycode);
        robot.keyRelease(keycode);
        robot.delay(550);
        return keycode;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10652().hitKey(keycode);
    }
}
