import java.awt.*;
import javax.swing.*;

public class MyJVMTest_15777 {

    void createAndShowGUI() {
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        JButton rButton = new JButton("Rollover");
        rButton.setRolloverEnabled(true);
        JToolBar nrToolbar = new JToolBar();
        nrToolbar.add(rButton);
        nrToolbar.remove(rButton);
        if (!rButton.isRolloverEnabled()) {
            throw new Error("Failed (bug 4260485): " + "toolbar overrode button's rollover property");
        }
        JToolBar rToolbar = new JToolBar();
        rToolbar.putClientProperty("JToolBar.isRollover", Boolean.TRUE);
        rToolbar.add(button = new JButton("Test"));
        rToolbar.add(toogleButton = new JToggleButton("Test"));
        frame.getContentPane().add(rToolbar, BorderLayout.NORTH);
        frame.setVisible(true);
    }

    static JButton button = null;

    static JToggleButton toogleButton = null;

    void run() {
        createAndShowGUI();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15777().run();
    }
}
