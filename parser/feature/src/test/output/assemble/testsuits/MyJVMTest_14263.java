import javax.swing.*;
import java.awt.*;

public class MyJVMTest_14263 {

    static JPopupMenu popup = null;

    void run() {
        popup = new JPopupMenu();
        popup.add(new JMenuItem("item"));
        popup.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14263().run();
    }
}
