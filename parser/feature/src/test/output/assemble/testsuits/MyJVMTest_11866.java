import javax.swing.*;
import java.awt.*;

public class MyJVMTest_11866 {

    static JTextField jtf = null;

    void run() {
        jtf = new JTextField("WW");
        JFrame frame = new JFrame();
        frame.getContentPane().add(jtf);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11866().run();
    }
}
