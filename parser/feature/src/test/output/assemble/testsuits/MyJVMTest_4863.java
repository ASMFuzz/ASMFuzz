import javax.swing.*;
import java.awt.*;

public class MyJVMTest_4863 {

    static JPopupMenu popup = null;

    void run() {
        popup = new JPopupMenu();
        popup.add(new JMenuItem("item"));
        popup.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4863().run();
    }
}
