import java.awt.*;
import javax.swing.*;

public class MyJVMTest_13054 {

    static JFrame frame = null;

    static JScrollPane scrollPane = null;

    static Point p = null;

    void run() {
        BoundedRangeModel model = scrollPane.getVerticalScrollBar().getModel();
        if (model.getValue() + model.getExtent() != model.getMaximum()) {
            frame.dispose();
            throw new RuntimeException("Invalid HTML position");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13054().run();
    }
}
