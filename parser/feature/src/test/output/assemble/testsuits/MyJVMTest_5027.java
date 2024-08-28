import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;

public class MyJVMTest_5027 {

    static JFrame frame = null;

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
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5027().createAndShowGUI();
    }
}
