import javax.swing.*;
import java.awt.*;

public class MyJVMTest_12940 {

    static JPopupMenu popupMenu = null;

    static JFrame frame = null;

    void setupUI() {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                frame = new JFrame();
                frame.setVisible(true);
                popupMenu = new JPopupMenu();
                JMenuItem click = new JMenuItem("Click");
                popupMenu.add(click);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12940().run();
    }
}
