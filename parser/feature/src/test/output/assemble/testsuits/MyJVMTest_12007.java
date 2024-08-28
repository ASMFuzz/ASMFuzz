import java.awt.*;

public class MyJVMTest_12007 {

    static Robot robot = null;

    static Insets expectedInsets = null;

    Insets getExpectedInsets() {
        Frame frame = new Frame();
        frame.setVisible(true);
        robot.waitForIdle();
        robot.delay(200);
        Insets expectedInsets = frame.getInsets();
        frame.dispose();
        return expectedInsets;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12007().getExpectedInsets());
    }
}
