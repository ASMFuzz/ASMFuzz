import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MyJVMTest_9652 {

    static Component comp = new Container();

    static Robot robot = new Robot();

    Component clickComponent(Component comp, Robot robot) {
        if (comp instanceof Choice) {
            return;
        }
        Point compLoc = comp.getLocationOnScreen();
        Dimension size = comp.getSize();
        robot.mouseMove(compLoc.x + size.width / 2, compLoc.y + size.height / 2);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        return comp;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9652().clickComponent(comp, robot);
    }
}
