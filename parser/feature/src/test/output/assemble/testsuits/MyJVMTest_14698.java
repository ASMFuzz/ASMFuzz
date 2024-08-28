import javax.swing.*;
import java.awt.*;

public class MyJVMTest_14698 {

    static JButton jButton1 = null;

    static JButton jButton4 = null;

    static JFrame frame1 = null;

    static Container contentPane = null;

    void init() {
        frame1 = new JFrame("Testing getMousePosition() on LWs");
        jButton1 = new JButton("C1");
        jButton4 = new JButton("C4");
        contentPane = frame1.getContentPane();
        contentPane.setLayout(new GridLayout(2, 2, 25, 25));
        contentPane.add(jButton1);
        contentPane.add(new JButton("C2"));
        contentPane.add(new JButton("C3"));
        contentPane.add(jButton4);
        frame1.setSize(200, 200);
        frame1.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14698().init();
    }
}
