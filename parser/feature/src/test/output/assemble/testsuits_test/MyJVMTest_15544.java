import java.awt.*;
import javax.swing.*;

public class MyJVMTest_15544 {

    void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("IM with L&F");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextArea description = new JTextArea("Please try typing using below-the-spot IM.\n\n eg. Use City IM with the following arguement:\n    -Djava.awt.im.style=below-the-spot");
        description.setPreferredSize(new Dimension(250, 70));
        description.setEditable(false);
        frame.getContentPane().add(description, BorderLayout.NORTH);
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(275, 50));
        frame.getContentPane().add(textField, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15544().createAndShowGUI();
    }
}
