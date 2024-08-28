import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;

public class MyJVMTest_10357 {

    static JTree tree = null;

    void startPathEditing() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                tree.startEditingAtPath(tree.getPathForRow(0));
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10357().run();
    }
}
