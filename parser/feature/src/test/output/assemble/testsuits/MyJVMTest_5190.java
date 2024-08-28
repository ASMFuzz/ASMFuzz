import javax.swing.*;
import java.awt.*;

public class MyJVMTest_5190 {

    void setup(JFrame frame) {
        bar = new JScrollBar(Adjustable.VERTICAL, 500, 0, 0, 1000);
        frame.getContentPane().add(bar);
        frame.setSize(50, 250);
        frame.setLocation(100, 100);
        frame.setVisible(true);
    }

    static JFrame frame = null;

    static JScrollBar bar = null;

    void run() {
        frame = new JFrame();
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setup(frame);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5190().run();
    }
}
