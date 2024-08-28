import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MyJVMTest_11087 {

    static JList list = null;

    void scrollDownExtendSelection() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                list.getActionMap().get("scrollDownExtendSelection").actionPerformed(new ActionEvent(list, ActionEvent.ACTION_PERFORMED, null));
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11087().run();
    }
}
