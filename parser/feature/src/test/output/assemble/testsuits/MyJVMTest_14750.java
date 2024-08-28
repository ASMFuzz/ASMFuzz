import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MyJVMTest_14750 {

    static Component comp = new Container();

    static Robot robot = new Robot();

    void clickComponent(Component comp, Robot robot) {
        if (comp instanceof Choice) {
            return;
        }
        Point compLoc = comp.getLocationOnScreen();
        Dimension size = comp.getSize();
        robot.mouseMove(compLoc.x + size.width / 2, compLoc.y + size.height / 2);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    Component performFocusClick(Component comp, Robot robot) {
        clickComponent(comp, robot);
        return comp;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14750().performFocusClick(comp, robot);
    }
}
