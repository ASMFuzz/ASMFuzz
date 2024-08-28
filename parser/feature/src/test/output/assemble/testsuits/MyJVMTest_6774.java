import javax.swing.*;
import java.awt.*;

public class MyJVMTest_6774 {

    static JButton b1 = null;

    void createGui() {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        b1 = new JButton("Button1");
        frame.add(b1);
        frame.add(new JButton("Button2"));
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        b1.requestFocus();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6774().createGui();
    }
}
