import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_9838 {

    void createAndShowGUI() {
        fr = new JFrame("Test");
        JLabel label = new JLabel("picture");
        label.setPreferredSize(new Dimension(500, 500));
        spane = new JScrollPane(label);
        fr.getContentPane().add(spane);
        sbar = spane.getVerticalScrollBar();
        fr.setSize(200, 200);
        fr.setVisible(true);
    }

    static JScrollPane spane = null;

    static JScrollBar sbar = null;

    static JFrame fr = null;

    void run() {
        createAndShowGUI();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9838().run();
    }
}
