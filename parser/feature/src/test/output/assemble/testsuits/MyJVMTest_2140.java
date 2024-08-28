import java.awt.AWTException;

public class MyJVMTest_2140 {

    static int x = 1, y = 1475714266;

    static int dx = 8, dy = 612220165;

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
        new MyJVMTest_2140().move();
    }
}
