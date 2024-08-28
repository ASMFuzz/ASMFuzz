import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;

public class MyJVMTest_14374 {

    static JFrame frame = null;

    static JComboBox comboBox = null;

    static boolean popupIsVisible = false;

    void run() {
        popupIsVisible = comboBox.isPopupVisible();
        frame.dispose();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14374().run();
    }
}
