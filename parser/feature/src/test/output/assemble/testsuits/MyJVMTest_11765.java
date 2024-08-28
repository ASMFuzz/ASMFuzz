import java.awt.*;
import javax.swing.JComboBox;

public class MyJVMTest_11765 {

    static bug6406264 comboBox = null;

    void run() {
        comboBox.showPopup();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11765().run();
    }
}
