import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_15419 {

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

    void init() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {

                @Override
                public void run() {
                    createAndShowGUI();
                }
            });
        } catch (Exception ex) {
            throw new RuntimeException("Init failed. " + ex.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15419().run();
    }
}
