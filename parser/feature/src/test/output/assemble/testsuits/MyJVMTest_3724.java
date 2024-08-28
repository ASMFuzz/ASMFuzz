import javax.swing.*;
import java.awt.*;

public class MyJVMTest_3724 {

    static JPopupMenu popupMenu = null;

    static JFrame frame = null;

    void run() {
        frame = new JFrame();
        frame.setVisible(true);
        popupMenu = new JPopupMenu();
        JMenuItem click = new JMenuItem("Click");
        popupMenu.add(click);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3724().run();
    }
}
