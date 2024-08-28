import javax.swing.*;
import java.awt.*;

public class MyJVMTest_12034 {

    static JFrame frame = null;

    static JComponent comp2 = null;

    GroupLayout setup(JFrame frame) {
        JPanel panel = new JPanel();
        JComponent comp1 = new JLabel("Test Label 1");
        comp1.setMinimumSize(new Dimension(1000, 40000));
        comp1.setPreferredSize(new Dimension(1000, 40000));
        JScrollPane scroll = new JScrollPane(comp1);
        comp2 = new JLabel("Test Label 2");
        GroupLayout layout = new GroupLayout(panel);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(scroll).addComponent(comp2));
        layout.setVerticalGroup(layout.createSequentialGroup().addComponent(scroll).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(comp2));
        panel.setLayout(layout);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setSize(800, 600);
        return layout;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12034().setup(frame);
    }
}
