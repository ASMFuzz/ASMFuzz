import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_17524 {

    static Point newFrameLocation = null;

    static JFrame frame = null;

    static Component titleComponent = null;

    void setNewFrameLocationEDT() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                newFrameLocation = new Point(frame.getLocationOnScreen().x + frame.getWidth() / 2, frame.getLocationOnScreen().y + titleComponent.getHeight() / 2);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17524().run();
    }
}
