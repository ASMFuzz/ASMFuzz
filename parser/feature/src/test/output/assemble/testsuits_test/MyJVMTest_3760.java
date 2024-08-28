import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class MyJVMTest_3760 {

    static JFrame frame = null;

    static boolean passed = false;

    static JSlider slider = new JSlider(0, 10);

    void stopEDT() {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                frame.dispose();
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3760().run();
    }
}
