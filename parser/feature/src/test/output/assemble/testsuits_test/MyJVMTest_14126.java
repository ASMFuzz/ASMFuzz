import javax.swing.*;
import java.awt.*;

public class MyJVMTest_14126 {

    static JFrame frame = null;

    static JScrollBar bar = null;

    JFrame setup(JFrame frame) {
        bar = new JScrollBar(Adjustable.VERTICAL, 500, 0, 0, 1000);
        frame.getContentPane().add(bar);
        frame.setSize(50, 250);
        frame.setLocation(100, 100);
        frame.setVisible(true);
        return frame;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14126().setup(frame);
    }
}
