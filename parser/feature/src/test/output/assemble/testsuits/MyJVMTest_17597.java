import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_17597 {

    static Point framePosition = null;

    static JFrame frame = null;

    void setFramePosEDT() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                framePosition = frame.getLocationOnScreen();
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17597().run();
    }
}
