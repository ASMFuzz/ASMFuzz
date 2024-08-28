import javax.swing.*;
import java.awt.*;

public class MyJVMTest_14328 {

    void setup(JFrame frame) {
        bar = new JProgressBar();
        bar.setBackground(Color.WHITE);
        bar.setValue(2);
        frame.getContentPane().add(bar, BorderLayout.NORTH);
        frame.getContentPane().setBackground(Color.GREEN);
        frame.setSize(200, 150);
        frame.setLocation(100, 100);
        frame.setVisible(true);
    }

    static JFrame frame = null;

    static JProgressBar bar = null;

    void run() {
        frame = new JFrame();
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setup(frame);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14328().run();
    }
}
