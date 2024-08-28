import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class MyJVMTest_14122 {

    static JPanel panel = null;

    static boolean passed = false;

    static JSlider slider = new JSlider(0, 10);

    Rectangle getPanelRectangle() throws Exception {
        final Rectangle[] result = new Rectangle[1];
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                result[0] = new Rectangle(panel.getLocationOnScreen(), panel.getSize());
            }
        });
        return result[0];
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14122().run();
    }
}
