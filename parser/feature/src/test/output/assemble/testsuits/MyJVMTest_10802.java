import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_10802 {

    static JScrollBar sbar = null;

    Point getClickPoint(final double scaleX, final double scaleY) throws Exception {
        final Point[] result = new Point[1];
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                Point p = sbar.getLocationOnScreen();
                Rectangle rect = sbar.getBounds();
                result[0] = new Point((int) (p.x + scaleX * rect.width), (int) (p.y + scaleY * rect.height));
            }
        });
        return result[0];
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10802().run();
    }
}
