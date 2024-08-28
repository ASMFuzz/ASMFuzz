import javax.swing.*;
import java.awt.*;

public class MyJVMTest_16528 {

    static JTabbedPane tabPane = null;

    static JFrame frame = null;

    void run() {
        for (int i = 0; i < 50; i++) {
            tabPane.setSelectedIndex(i % 2);
        }
        frame.dispose();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16528().run();
    }
}
