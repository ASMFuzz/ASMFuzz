import java.awt.*;
import javax.swing.JComboBox;

public class MyJVMTest_2495 {

    static bug6406264 comboBox = null;

    void run() {
        comboBox.showPopup();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2495().run();
    }
}
