import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;

public class MyJVMTest_9264 {

    static JTree tree = null;

    Point getClickPoint() throws Exception {
        final Point[] result = new Point[1];
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                Rectangle rect = tree.getRowBounds(0);
                Point p = new Point(rect.x + rect.width / 2, rect.y + 2);
                SwingUtilities.convertPointToScreen(p, tree);
                result[0] = p;
            }
        });
        return result[0];
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9264().run();
    }
}
