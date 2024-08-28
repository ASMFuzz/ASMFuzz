import java.awt.*;
import javax.swing.*;

public class MyJVMTest_13939 {

    static JButton button = null;

    Point getButtonCenter() throws Exception {
        final Point[] result = new Point[1];
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                Point p = button.getLocationOnScreen();
                Dimension size = button.getSize();
                result[0] = new Point(p.x + size.width / 2, p.y + size.height / 2);
            }
        });
        return result[0];
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13939().run();
    }
}
