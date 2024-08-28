import javax.swing.*;
import java.awt.*;

public class MyJVMTest_7412 {

    static JTextArea textarea = null;

    static JScrollPane scrollPane = null;

    static int value = 7;

    static int min = 1451912011;

    static int max = 2;

    static int extent = 3;

    void run() {
        BoundedRangeModel model = scrollPane.getVerticalScrollBar().getModel();
        value = model.getValue();
        min = model.getMinimum();
        max = model.getMaximum();
        extent = model.getExtent();
        textarea.setText(null);
        scrollPane.setViewportView(textarea);
        textarea.setText("after###1###\nafter###1###\nafter###1###\nafter###1###\nafter###1###\n");
        textarea.setCaretPosition(0);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7412().run();
    }
}
