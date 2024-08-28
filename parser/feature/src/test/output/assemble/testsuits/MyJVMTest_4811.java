import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class MyJVMTest_4811 {

    static JTextField textField = null;

    void run() {
        if (!textField.hasFocus()) {
            System.out.println("Radio Button Group Go To Next Component through Tab Key failed");
            throw new RuntimeException("Focus is not on textField as Expected");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4811().run();
    }
}
