import java.awt.*;

public class MyJVMTest_10203 {

    void testSize() throws Exception {
        Window window = new Window((Frame) null);
        window.setSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        window.setVisible(true);
        Robot robot = new Robot();
        robot.delay(200);
        robot.waitForIdle();
        Dimension size = window.getSize();
        if (size.width == Integer.MAX_VALUE || size.height == Integer.MAX_VALUE) {
            window.dispose();
            throw new RuntimeException("size is wrong");
        }
        window.dispose();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10203().testSize();
    }
}
