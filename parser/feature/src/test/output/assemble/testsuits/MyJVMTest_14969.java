import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_14969 {

    static Point newFrameLocation = null;

    static Rectangle gcBounds = null;

    boolean checkFrameIsOutOfScreenEDT() throws Exception {
        final boolean[] result = new boolean[1];
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                if (newFrameLocation.x > gcBounds.width || newFrameLocation.x < 0 || newFrameLocation.y > gcBounds.height || newFrameLocation.y < 0) {
                    result[0] = true;
                }
            }
        });
        return result[0];
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14969().run();
    }
}
