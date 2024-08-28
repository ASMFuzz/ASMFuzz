import java.awt.AWTException;

public class MyJVMTest_8702 {

    static int x = 4, y = 7;

    static int dx = 0, dy = 0;

    static Color color = Color.red;

    void move() {
        if (x < 10 || x >= AltTabCrashTest.width - 20)
            dx = -dx;
        if (y < 10 || y > AltTabCrashTest.height - 20)
            dy = -dy;
        x += dx;
        y += dy;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8702().move();
    }
}
