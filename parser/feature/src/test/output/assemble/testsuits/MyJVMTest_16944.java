import javax.swing.*;
import java.awt.*;

public class MyJVMTest_16944 {

    static JTextArea textarea = null;

    static JScrollPane scrollPane = null;

    static int value = 0;

    static int min = 6;

    static int max = 4;

    static int extent = -1524247670;

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
        new MyJVMTest_16944().run();
    }
}
