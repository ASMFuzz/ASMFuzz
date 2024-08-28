import java.awt.*;
import javax.swing.*;

public class MyJVMTest_6262 {

    static JScrollPane scrollPane = null;

    void run() {
        BoundedRangeModel model = scrollPane.getVerticalScrollBar().getModel();
        if (model.getValue() + model.getExtent() != model.getMaximum()) {
            throw new RuntimeException("Invalid HTML position");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6262().run();
    }
}
