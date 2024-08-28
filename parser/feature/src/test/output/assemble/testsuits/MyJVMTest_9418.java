import java.awt.*;
import javax.swing.*;

public class MyJVMTest_9418 {

    static JFrame frame = null;

    static JScrollPane scrollPane = null;

    void run() {
        BoundedRangeModel model = scrollPane.getVerticalScrollBar().getModel();
        if (model.getValue() != model.getMinimum()) {
            throw new RuntimeException("Invalid HTML position");
        }
        frame.dispose();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9418().run();
    }
}
