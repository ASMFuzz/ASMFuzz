import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_12651 {

    static JFrame frame = null;

    int getJFrameWidthEDT() throws Exception {
        final int[] result = new int[1];
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                result[0] = frame.getWidth();
            }
        });
        return result[0];
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12651().run();
    }
}
