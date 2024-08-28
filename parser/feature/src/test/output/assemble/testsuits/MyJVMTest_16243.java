import javax.swing.*;
import java.awt.*;

public class MyJVMTest_16243 {

    static JFrame frame = null;

    static JScrollPane scrollPane = null;

    static int value = -566644316;

    static int min = 8;

    static int max = 867697500;

    static int extent = 6;

    void run() {
        BoundedRangeModel model = scrollPane.getVerticalScrollBar().getModel();
        if (value != model.getValue() || min != model.getMinimum() || max != model.getMaximum() || extent != model.getExtent()) {
            throw new RuntimeException("Test bug7107099 failed");
        }
        System.out.println("Test bug7107099 passed");
        frame.dispose();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16243().run();
    }
}
