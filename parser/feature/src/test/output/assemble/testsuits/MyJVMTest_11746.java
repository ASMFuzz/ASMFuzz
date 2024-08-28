import javax.swing.*;
import java.awt.*;

public class MyJVMTest_11746 {

    static JButton button = null;

    void run() {
        button.requestFocusInWindow();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11746().run();
    }
}
