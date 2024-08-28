import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyJVMTest_3383 {

    static int N = 50;

    static JTabbedPane tabbedPane = null;

    static JFrame frame = null;

    void createAndShowUI() {
        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100, 100);
        tabbedPane = new JTabbedPane();
        for (int i = 0; i < N; i++) {
            tabbedPane.addTab("Tab: " + i, new JLabel("Test"));
        }
        tabbedPane.setSelectedIndex(0);
        frame.getContentPane().add(tabbedPane);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3383().createAndShowUI();
    }
}
