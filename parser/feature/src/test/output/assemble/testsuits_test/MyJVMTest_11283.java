import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MyJVMTest_11283 {

    static Object pickParam1 = 4;

    static ChangeEvent pick = new ChangeEvent(pickParam1);

    static JTabbedPane tabbedPane = null;

    static boolean bStateChanged = false;

    void createAndShowUI() {
        final JFrame frame = new JFrame();
        tabbedPane = new JTabbedPane();
        tabbedPane.add("Tab0", new JPanel());
        tabbedPane.add("Tab1", new JPanel());
        tabbedPane.add("Tab2", new JPanel());
        tabbedPane.setSelectedIndex(2);
        tabbedPane.addChangeListener(new ChangeListener() {

            public ChangeEvent stateChanged(final ChangeEvent pick) {
                bStateChanged = true;
                if (tabbedPane.getTabCount() == 3) {
                    tabbedPane.remove(2);
                }
                return pick;
            }
        });
        frame.getContentPane().add(tabbedPane);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11283().stateChanged(pick);
    }
}
