import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class MyJVMTest_8904 {

    static int keycode = 0;

    static Robot robot = null;

    int hitKey(int keycode) {
        robot.keyPress(keycode);
        robot.keyRelease(keycode);
        robot.delay(550);
        return keycode;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8904().hitKey(keycode);
    }
}
