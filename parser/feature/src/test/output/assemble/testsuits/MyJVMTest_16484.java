import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class MyJVMTest_16484 {

    void createAndShowGUI() {
        JFrame mainFrame = new JFrame("Bug 8075609 - 1 test");
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout());
        JPanel formPanel = new JPanel();
        formPanel.setFocusTraversalPolicy(new LayoutFocusTraversalPolicy());
        formPanel.setFocusCycleRoot(true);
        JRadioButton option1 = new JRadioButton("Option 1", true);
        JRadioButton option2 = new JRadioButton("Option 2");
        ButtonGroup radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(option1);
        radioButtonGroup.add(option2);
        formPanel.add(option1);
        formPanel.add(option2);
        textField = new JTextField("Another focusable component");
        formPanel.add(textField);
        rootPanel.add(formPanel, BorderLayout.CENTER);
        JButton okButton = new JButton("OK");
        rootPanel.add(okButton, BorderLayout.SOUTH);
        mainFrame.add(rootPanel);
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.toFront();
    }

    static JTextField textField = null;

    void run() {
        createAndShowGUI();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16484().run();
    }
}
