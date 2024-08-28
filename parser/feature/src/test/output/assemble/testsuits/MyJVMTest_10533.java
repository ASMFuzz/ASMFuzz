import javax.swing.*;
import java.awt.*;

public class MyJVMTest_10533 {

    static JFrame frame = null;

    static Component left = null;

    void setupUI1() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        left = new JPanel();
        left.setPreferredSize(new Dimension(100, 100));
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(100, 50));
        Component right = new JScrollPane(rightPanel);
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, right);
        frame = new JFrame();
        frame.add(split);
        frame.pack();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10533().setupUI1();
    }
}
