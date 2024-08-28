import javax.swing.*;
import java.awt.*;

public class MyJVMTest_11469 {

    void run() {
        JToolBar tb = new JToolBar();
        Dimension preferredSize = tb.getPreferredSize();
        JButton button = new JButton("Test");
        button.setVisible(false);
        tb.add(button);
        if (!preferredSize.equals(tb.getPreferredSize())) {
            throw new RuntimeException("Toolbar's preferredSize is wrong");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11469().run();
    }
}
