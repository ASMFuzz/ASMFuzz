import javax.swing.*;
import java.awt.*;

public class MyJVMTest_15756 {

    static JFrame frame = null;

    void checkFocusOwner(final Component component) throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                if (component != frame.getFocusOwner()) {
                    throw new RuntimeException("Test Failed! Incorrect focus owner: " + frame.getFocusOwner() + ", but expected: " + component);
                }
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15756().run();
    }
}
