import javax.swing.*;
import java.awt.*;

public class MyJVMTest_18186 {

    static JFrame frame = null;

    void setupUI2() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18186().setupUI2();
    }
}
