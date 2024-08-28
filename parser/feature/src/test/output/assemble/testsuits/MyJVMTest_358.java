import java.awt.*;
import javax.swing.JComboBox;

public class MyJVMTest_358 {

    static bug6406264 comboBox = null;

    void run() {
        if (comboBox.getUI().isPopupVisible(comboBox) == false) {
            throw new RuntimeException("A focusable popup is not visible " + "in JComboBox!");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_358().run();
    }
}
