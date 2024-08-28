import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MyJVMTest_2003 {

    void createAndShowUI() {
        frame = new JFrame();
        tabbedPane = new JTabbedPane();
        tabbedPane.add("Tab0", new JPanel());
        tabbedPane.add("Tab1", new JPanel());
        tabbedPane.add("Tab2", new JPanel());
        tabbedPane.setSelectedIndex(2);
        tabbedPane.addChangeListener(new ChangeListener() {

            public void stateChanged(final ChangeEvent pick) {
                bStateChanged = true;
                if (tabbedPane.getTabCount() == 3) {
                    tabbedPane.remove(2);
                }
            }
        });
        frame.getContentPane().add(tabbedPane);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    void stateChanged(final ChangeEvent pick) {
        bStateChanged = true;
        if (tabbedPane.getTabCount() == 3) {
            tabbedPane.remove(2);
        }
    }

    static JTabbedPane tabbedPane = null;

    static boolean bStateChanged = false;

    static JFrame frame = null;

    void run() {
        createAndShowUI();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2003().run();
    }
}
