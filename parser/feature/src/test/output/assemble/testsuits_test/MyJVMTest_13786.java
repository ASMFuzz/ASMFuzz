import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_13786 {

    static JMenu fileMenu = null;

    boolean isParentOpaque() throws Exception {
        final boolean[] result = new boolean[1];
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                result[0] = fileMenu.getPopupMenu().getParent().isOpaque();
            }
        });
        return result[0];
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13786().run();
    }
}
