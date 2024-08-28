import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MyJVMTest_12069 {

    static JList list = null;

    Point clickItem4() throws Exception {
        final Point[] result = new Point[1];
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                Rectangle r = list.getCellBounds(4, 4);
                Point p = new Point(r.x + r.width / 2, r.y + r.height / 2);
                SwingUtilities.convertPointToScreen(p, list);
                result[0] = p;
            }
        });
        return result[0];
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12069().run();
    }
}
