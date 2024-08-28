import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MyJVMTest_6860 {

    static int timeout = 0;

    static int DEF_WIDTH = 400, DEF_HEIGHT = 300, DEF_TOP = 1, DEF_LEFT = 100, DEF_ROW = 0, DEF_COL = 0;

    static boolean automatic = true;

    static Robot robot = null;

    int pause(int timeout) {
        Toolkit.getDefaultToolkit().sync();
        robot.waitForIdle();
        robot.delay(100);
        return timeout;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6860().pause(timeout);
    }
}
