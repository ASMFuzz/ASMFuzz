import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_13824 {

    static Container c = new Container();

    static Button b = null;

    static Dialog d = null;

    static Robot robot = null;

    Dimension moveMouseOver(Container c) {
        Point p = c.getLocationOnScreen();
        Dimension d = c.getSize();
        robot.mouseMove(p.x + (int) (d.getWidth() / 2), p.y + (int) (d.getHeight() / 2));
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13824().moveMouseOver(c);
    }
}
