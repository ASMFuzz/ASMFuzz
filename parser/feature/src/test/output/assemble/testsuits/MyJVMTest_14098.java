import javax.swing.*;
import java.awt.*;

public class MyJVMTest_14098 {

    static JSlider slider = null;

    static Robot robot = null;

    void run() {
        Point p = slider.getLocationOnScreen();
        robot.mouseMove(p.x, p.y);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14098().run();
    }
}
