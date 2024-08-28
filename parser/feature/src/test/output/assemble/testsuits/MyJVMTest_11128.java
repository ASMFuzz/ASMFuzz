import java.awt.*;

public class MyJVMTest_11128 {

    static Frame frame = new Frame();

    Frame test(Frame frame) {
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        try {
            Thread.sleep(1000);
        } catch (Exception ex) {
        }
        if (frame.getExtendedState() != Frame.MAXIMIZED_BOTH) {
            throw new RuntimeException("The maximized state has not been applied");
        }
        frame.dispose();
        try {
            Thread.sleep(1000);
        } catch (Exception ex) {
        }
        if (frame.getExtendedState() != Frame.MAXIMIZED_BOTH) {
            throw new RuntimeException("The maximized state has been reset");
        }
        return frame;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11128().test(frame);
    }
}
