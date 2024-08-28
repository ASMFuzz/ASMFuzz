import javax.swing.*;
import java.awt.*;

public class MyJVMTest_17550 {

    static JFrame frame = null;

    static JProgressBar bar = null;

    JFrame setup(JFrame frame) {
        bar = new JProgressBar();
        bar.setBackground(Color.WHITE);
        bar.setValue(2);
        frame.getContentPane().add(bar, BorderLayout.NORTH);
        frame.getContentPane().setBackground(Color.GREEN);
        frame.setSize(200, 150);
        frame.setLocation(100, 100);
        frame.setVisible(true);
        return frame;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17550().setup(frame);
    }
}
