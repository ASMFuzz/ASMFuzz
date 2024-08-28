import javax.swing.*;
import java.awt.*;

public class MyJVMTest_2909 {

    static JTextField textField = null;

    static JButton button = null;

    static JFrame frame = null;

    void run() {
        frame = new JFrame("Test");
        textField = new JTextField("test selection for textfield");
        button = new JButton("To compete the focus");
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(textField);
        frame.getContentPane().add(button);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2909().run();
    }
}
