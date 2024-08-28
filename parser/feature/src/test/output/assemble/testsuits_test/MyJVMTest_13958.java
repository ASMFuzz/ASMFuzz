import javax.swing.*;
import java.awt.*;

public class MyJVMTest_13958 {

    void setup(JFrame frame) {
        area = new JTextArea();
        frame.getContentPane().add(new JScrollPane(area));
        area.setText("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        area.getCaret().setDot(area.getText().length() + 1);
        frame.setSize(300, 200);
        frame.setVisible(true);
        area.requestFocus();
    }

    static JFrame frame = null;

    static JTextArea area = null;

    void run() {
        frame = new JFrame();
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setup(frame);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13958().run();
    }
}
