import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class MyJVMTest_8884 {

    static Robot robot = null;

    static JEditorPane ep = null;

    void run() throws Exception {
        robot = new Robot();
        ep = new JEditorPane();
        ep.setContentType("text/html");
        ep.setPreferredSize(new Dimension(100, 100));
        JFrame frame = new JFrame("Test: " + getClass().getName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(ep);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8884().run();
    }
}
