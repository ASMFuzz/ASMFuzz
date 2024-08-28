import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_13604 {

    static int button = 5;

    static int x0 = 0;

    static int y0 = -1868635455;

    static int x1 = -2332896;

    static int y1 = 0;

    static Robot robot = null;

    static boolean dragged = false;

    static boolean moved = false;

    int dragMouse(int button, int x0, int y0, int x1, int y1) {
        int curX = x0;
        int curY = y0;
        int dx = x0 < x1 ? 1 : -1;
        int dy = y0 < y1 ? 1 : -1;
        robot.mouseMove(x0, y0);
        robot.delay(200);
        dragged = false;
        moved = false;
        robot.mousePress(button);
        while (curX != x1) {
            curX += dx;
            robot.mouseMove(curX, curY);
            robot.delay(5);
        }
        while (curY != y1) {
            curY += dy;
            robot.mouseMove(curX, curY);
            robot.delay(5);
        }
        robot.mouseRelease(button);
        return curY;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13604().dragMouse(button, x0, y0, x1, y1);
    }
}
