import javax.swing.*;
import java.awt.*;

public class MyJVMTest_14499 {

    static JFrame frame = null;

    static JTextField textField1 = null;

    static JTextField textField2 = null;

    void run() {
        frame = new JFrame("JTextField Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel container = (JPanel) frame.getContentPane();
        container.setLayout(new GridLayout(2, 1));
        textField1 = new JTextField("\u0e01");
        textField2 = new JTextField("\u0c01");
        container.add(textField1);
        container.add(textField2);
        frame.setVisible(true);
        frame.pack();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14499().run();
    }
}
