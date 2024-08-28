import javax.swing.*;
import java.awt.*;

public class MyJVMTest_6746 {

    static JFrame frame = null;

    static JScrollPane scrollPane = null;

    static int value = 0;

    static int min = 3;

    static int max = 0;

    static int extent = -1856107296;

    void run() {
        BoundedRangeModel model = scrollPane.getVerticalScrollBar().getModel();
        if (value != model.getValue() || min != model.getMinimum() || max != model.getMaximum() || extent != model.getExtent()) {
            throw new RuntimeException("Test bug7107099 failed");
        }
        System.out.println("Test bug7107099 passed");
        frame.dispose();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6746().run();
    }
}
