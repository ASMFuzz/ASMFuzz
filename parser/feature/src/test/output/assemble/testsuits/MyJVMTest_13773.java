import javax.swing.*;
import java.awt.*;

public class MyJVMTest_13773 {

    static int keycode = 0;

    void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    static Robot robot = null;

    int hitKey(int keycode) {
        robot.keyPress(keycode);
        robot.keyRelease(keycode);
        delay();
        return keycode;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13773().hitKey(keycode);
    }
}
