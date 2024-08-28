import javax.swing.*;
import java.awt.*;

public class MyJVMTest_6643 {

    static JFrame frame = null;

    static JTextField textField = null;

    static JButton button = null;

    void createAndShowGUI() {
        frame = new JFrame("SwingFocusTransitionTest");
        frame.setSize(300, 300);
        frame.setFocusTraversalPolicyProvider(true);
        frame.setFocusTraversalPolicy(new LayoutFocusTraversalPolicy());
        textField = new JTextField();
        button = new JButton();
        JPanel panel = new JPanel();
        panel.setFocusTraversalPolicyProvider(true);
        panel.setFocusTraversalPolicy(new DefaultFocusTraversalPolicy());
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3, 1));
        p.add(textField);
        p.add(button);
        p.add(panel);
        frame.add(p);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6643().createAndShowGUI();
    }
}
