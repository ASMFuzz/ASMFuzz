import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;

public class MyJVMTest_17658 {

    static JTree tree = null;

    static Robot robot = null;

    void assertEditingNoTreeLock(final boolean editing) throws Exception {
        robot.waitForIdle();
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                if (editing && !tree.isEditing()) {
                    throw new RuntimeException("Tree should be editing");
                }
                if (!editing && tree.isEditing()) {
                    throw new RuntimeException("Tree should not be editing");
                }
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17658().run();
    }
}
