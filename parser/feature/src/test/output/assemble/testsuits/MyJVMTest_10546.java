import javax.swing.*;
import java.awt.*;

public class MyJVMTest_10546 {

    static JPopupMenu popup = null;

    void run() {
        popup.setVisible(false);
        popup.removeAll();
        popup.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10546().run();
    }
}
