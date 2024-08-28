import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_13132 {

    static JMenu fileMenu = null;

    Point getMenuClickPoint() throws Exception {
        final Point[] result = new Point[1];
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                Point p = fileMenu.getLocationOnScreen();
                Dimension size = fileMenu.getSize();
                result[0] = new Point(p.x + size.width / 2, p.y + size.height / 2);
            }
        });
        return result[0];
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13132().run();
    }
}
