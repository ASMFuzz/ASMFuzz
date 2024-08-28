import java.awt.*;
import javax.swing.*;

public class MyJVMTest_11742 {

    static JFrame frame = null;

    static JScrollPane scrollPane = null;

    static Point p = null;

    void run() {
        BoundedRangeModel model = scrollPane.getVerticalScrollBar().getModel();
        if (model.getValue() != model.getMinimum()) {
            frame.dispose();
            throw new RuntimeException("Invalid HTML position");
        }
        frame.dispose();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11742().run();
    }
}
