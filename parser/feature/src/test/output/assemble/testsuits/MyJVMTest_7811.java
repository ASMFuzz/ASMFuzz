import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_7811 {

    void createAndShowGUI() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("JFrame Dance Test");
        frame.pack();
        frame.setSize(450, 260);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static JFrame frame = null;

    void run() {
        createAndShowGUI();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7811().run();
    }
}
