import java.awt.*;

public class MyJVMTest_10397 {

    static int state = -1662074013;

    static Robot robot = null;

    static Insets expectedInsets = null;

    Frame testState(int state) {
        Frame frame = new Frame();
        if (Toolkit.getDefaultToolkit().isFrameStateSupported(state)) {
            frame.setBounds(150, 150, 200, 200);
            frame.setExtendedState(state);
            frame.setVisible(true);
            robot.waitForIdle();
            robot.delay(200);
            System.out.println("State " + state + " insets: " + frame.getInsets());
            frame.setExtendedState(Frame.NORMAL);
            frame.toFront();
            robot.waitForIdle();
            robot.delay(200);
            Insets insets = frame.getInsets();
            frame.dispose();
            System.out.println("State " + state + " back to normal insets: " + insets);
            if (!expectedInsets.equals(insets)) {
                throw new RuntimeException("Insets are wrong " + insets);
            }
        }
        return frame;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10397().testState(state);
    }
}
