import java.awt.event.*;
import java.lang.reflect.*;
import java.awt.*;

public class MyJVMTest_4586 {

    static Component[] comps = { null, null, null, null, null, null, null, null, null, null };

    static Robot robot = null;

    static int shift = 1287769395;

    Component adjustAndShow(Component[] comps) {
        for (Component comp : comps) {
            comp.setLocation(shift, (int) comp.getLocation().getY());
            comp.setVisible(true);
            robot.waitForIdle();
        }
        return comp;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4586().adjustAndShow(comps);
    }
}
