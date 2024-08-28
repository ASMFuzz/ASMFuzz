import javax.swing.*;
import java.awt.*;

public class MyJVMTest_12598 {

    static JTree tree = null;

    static JCheckBox checkbox = null;

    Point getRowPointToClick(final int row) throws Exception {
        final Point[] result = new Point[1];
        SwingUtilities.invokeAndWait(new Runnable() {

            public void run() {
                Rectangle rect = tree.getRowBounds(row);
                Point point = new Point(rect.x + 10, rect.y + rect.height / 2);
                SwingUtilities.convertPointToScreen(point, tree);
                result[0] = point;
            }
        });
        return result[0];
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12598().run();
    }
}
