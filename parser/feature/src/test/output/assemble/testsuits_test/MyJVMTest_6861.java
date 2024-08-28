import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.metal.*;

public class MyJVMTest_6861 {

    static JComboBox comboBox = null;

    void run() {
        comboBox.showPopup();
        comboBox.hidePopup();
        comboBox.showPopup();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6861().run();
    }
}
