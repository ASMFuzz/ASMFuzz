import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_14029 {

    static Component comp = new Container();

    static boolean up = true;

    static int REPS = 5;

    static Robot robot = null;

    Component testComp(Component comp, boolean up) {
        Point loc = comp.getLocationOnScreen();
        robot.mouseMove(loc.x + comp.getWidth() / 2, loc.y + comp.getHeight() / 2);
        for (int loop = 0; loop < REPS; loop++) {
            System.out.println("Robot.mouseWheel() on " + comp.getName());
            robot.mouseWheel(up ? -1 : 1);
        }
        return comp;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14029().testComp(comp, up);
    }
}
