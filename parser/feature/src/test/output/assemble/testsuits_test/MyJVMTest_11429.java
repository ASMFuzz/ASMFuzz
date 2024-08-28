import javax.swing.*;
import java.awt.*;

public class MyJVMTest_11429 {

    static JFrame frame = null;

    static JPopupMenu popup = null;

    static Toolkit toolkit = null;

    static Insets screenInsets = null;

    static Robot robot = null;

    void checkPopup() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {

            public void run() {
                Dimension screenSize = toolkit.getScreenSize();
                frame.setLocation(screenSize.width / 2, screenSize.height - frame.getHeight() - screenInsets.bottom);
                frame.setVisible(true);
            }
        });
        robot.waitForIdle();
        final Point point = new Point();
        SwingUtilities.invokeAndWait(new Runnable() {

            public void run() {
                point.x = 0;
                point.y = frame.getHeight() - popup.getPreferredSize().height + screenInsets.bottom;
                popup.show(frame, point.x, point.y);
            }
        });
        robot.waitForIdle();
        SwingUtilities.invokeAndWait(new Runnable() {

            public void run() {
                Point frameLoc = frame.getLocationOnScreen();
                if (popup.getLocationOnScreen().equals(new Point(frameLoc.x, frameLoc.y + point.y))) {
                    throw new RuntimeException("Popup is not shifted");
                }
                popup.setVisible(false);
                frame.dispose();
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11429().run();
    }
}
