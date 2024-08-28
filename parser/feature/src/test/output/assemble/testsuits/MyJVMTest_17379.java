import java.awt.*;

public class MyJVMTest_17379 {

    void testLocation() throws Exception {
        Window window = new Window((Frame) null);
        window.setSize(100, 100);
        window.setLocation(0, 0);
        window.setVisible(true);
        Robot robot = new Robot();
        robot.delay(200);
        robot.waitForIdle();
        Point location1 = window.getLocation();
        Point location2 = window.getLocationOnScreen();
        window.setLocation(10000, 10000);
        if (!location1.equals(location2)) {
            window.dispose();
            throw new RuntimeException("getLocation is different");
        }
        robot.delay(200);
        robot.waitForIdle();
        location1 = window.getLocation();
        location2 = window.getLocationOnScreen();
        if (!location1.equals(location2)) {
            window.dispose();
            throw new RuntimeException("getLocation is different");
        }
        window.dispose();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17379().testLocation();
    }
}
