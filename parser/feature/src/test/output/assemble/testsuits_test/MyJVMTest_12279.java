import javax.swing.*;
import java.awt.*;

public class MyJVMTest_12279 {

    static JFrame frame = null;

    static JLabel label = null;

    void run() {
        label = new JLabel("A JLabel used as object for an HTML-formatted tooltip");
        label.setToolTipText("<html><body bgcolor=FFFFE1>An HTML-formatted ToolTip</body></html>");
        frame = new JFrame();
        frame.add(label);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12279().run();
    }
}
