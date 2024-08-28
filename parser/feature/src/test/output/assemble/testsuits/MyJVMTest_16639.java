import java.awt.*;

public class MyJVMTest_16639 {

    static GraphicsConfiguration gc = null;

    static boolean undecorated = false;

    Rectangle getMaximizedScreenArea(GraphicsConfiguration gc) {
        Rectangle bounds = gc.getBounds();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(gc);
        return new Rectangle(bounds.x + insets.left, bounds.y + insets.top, bounds.width - insets.left - insets.right, bounds.height - insets.top - insets.bottom);
    }

    Frame testMaximizedBounds(GraphicsConfiguration gc, boolean undecorated) throws Exception {
        Frame frame = null;
        try {
            Rectangle maxArea = getMaximizedScreenArea(gc);
            Robot robot = new Robot();
            robot.setAutoDelay(50);
            frame = new Frame();
            frame.setUndecorated(undecorated);
            Rectangle maximizedBounds = new Rectangle(maxArea.x + maxArea.width / 6, maxArea.y + maxArea.height / 6, maxArea.width / 3, maxArea.height / 3);
            frame.setMaximizedBounds(maximizedBounds);
            frame.setSize(maxArea.width / 8, maxArea.height / 8);
            frame.setVisible(true);
            robot.waitForIdle();
            frame.setExtendedState(Frame.MAXIMIZED_BOTH);
            robot.waitForIdle();
            robot.delay(1000);
            Rectangle bounds = frame.getBounds();
            if (!bounds.equals(maximizedBounds)) {
                throw new RuntimeException("The bounds of the Frame do not equal to what" + " is specified when the frame is in Frame.MAXIMIZED_BOTH state");
            }
            frame.setExtendedState(Frame.NORMAL);
            robot.waitForIdle();
            robot.delay(1000);
            maximizedBounds = new Rectangle(maxArea.x + maxArea.width / 10, maxArea.y + maxArea.height / 10, maxArea.width / 5, maxArea.height / 5);
            frame.setMaximizedBounds(maximizedBounds);
            frame.setExtendedState(Frame.MAXIMIZED_BOTH);
            robot.waitForIdle();
            robot.delay(1000);
            bounds = frame.getBounds();
            if (!bounds.equals(maximizedBounds)) {
                throw new RuntimeException("The bounds of the Frame do not equal to what" + " is specified when the frame is in Frame.MAXIMIZED_BOTH state");
            }
        } finally {
            if (frame != null) {
                frame.dispose();
            }
        }
        return frame;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16639().testMaximizedBounds(gc, undecorated);
    }
}
