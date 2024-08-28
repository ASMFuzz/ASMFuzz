import java.awt.*;
import javax.swing.*;

public class MyJVMTest_15738 {

    static JScrollPane scrollPane = null;

    void run() {
        BoundedRangeModel model = scrollPane.getVerticalScrollBar().getModel();
        if (model.getValue() + model.getExtent() != model.getMaximum()) {
            throw new RuntimeException("Invalid HTML position");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15738().run();
    }
}
