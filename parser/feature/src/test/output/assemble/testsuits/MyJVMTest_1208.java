import javax.swing.*;
import java.awt.*;

public class MyJVMTest_1208 {

    static JTextField textField = null;

    void run() {
        textField.requestFocusInWindow();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1208().run();
    }
}
