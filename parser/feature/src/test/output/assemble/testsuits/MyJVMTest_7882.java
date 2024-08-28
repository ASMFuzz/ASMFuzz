import javax.swing.*;
import java.awt.*;

public class MyJVMTest_7882 {

    static JFrame frame = null;

    static JLabel label = null;

    void run() {
        frame = new JFrame();
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7882().run();
    }
}
