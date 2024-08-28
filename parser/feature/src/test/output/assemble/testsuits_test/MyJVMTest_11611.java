import java.awt.*;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class MyJVMTest_11611 {

    static JFrame frame = null;

    static bug6406264 comboBox = null;

    void run() {
        frame = new JFrame("JComboBox6406264 test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        comboBox = new bug6406264("One", "Two", "Three");
        frame.getContentPane().add(comboBox);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11611().run();
    }
}
