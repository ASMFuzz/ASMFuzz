import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class MyJVMTest_14906 {

    static JEditorPane jep = null;

    Point getJEPLocOnScreen() throws Exception {
        final Point[] result = new Point[1];
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                result[0] = jep.getLocationOnScreen();
            }
        });
        return result[0];
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14906().run();
    }
}
