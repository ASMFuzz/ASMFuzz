import javax.swing.*;
import java.awt.*;

public class MyJVMTest_2226 {

    static JTabbedPane tabbedPane = null;

    static JFrame frame = null;

    void run() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tabbedPane = new JTabbedPane();
        tabbedPane.setTabPlacement(JTabbedPane.LEFT);
        tabbedPane.addTab("Hello", null);
        frame.add(tabbedPane);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2226().run();
    }
}
